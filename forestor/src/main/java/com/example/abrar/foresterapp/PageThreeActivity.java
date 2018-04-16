package com.example.abrar.foresterapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.pdf.PdfDocument;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.os.Handler;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class PageThreeActivity extends AppCompatActivity {
    private FusedLocationProviderClient client;
    private ArrayList<Integer> resultIDs;


    Timer timer = new Timer();
    Handler h;
    Geocoder geocoder;
    List<Address> addresses;
    String city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_three);

        client = LocationServices.getFusedLocationProviderClient(this);

        if (ActivityCompat.checkSelfPermission(PageThreeActivity.this, ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        client.getLastLocation().addOnSuccessListener(PageThreeActivity.this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    geocoder = new Geocoder(PageThreeActivity.this, Locale.getDefault());
                    TextView resultText = (TextView) findViewById(R.id.resultText);
                    try {
                        addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);

                        city = addresses.get(0).getSubAdminArea();

                        Forum.findByLocation(city);

                        resultText.setText("The Plants in your area are: \n");

                        resultIDs = Forum.plantsLocation;
                        for(int i=0; i< resultIDs.size(); i++){
                            resultText.append("Scientific name: " + Plant.getAttribute(resultIDs.get(i), 1));
                            resultText.append(", ");
                            resultText.append("Common name: " +Plant.getAttribute(resultIDs.get(i), 2));
                            resultText.append("\n");
                        }



                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });



    }


    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{ACCESS_FINE_LOCATION}, 1);
    }
}

