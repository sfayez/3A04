package com.example.abrar.foresterapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    String[][] plantData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Plant.getData(getPlantData());

        // only for testing.

    }

    public void identifyPage(View view) {
        startActivity(new Intent(this, PageTwoActivity.class));
    }
    public void locationPage(View view) {
        startActivity(new Intent(this, PageThreeActivity.class));
    }

    /**
     * Get all points in the dataset.
     *
     * @return
     */

    public String[][] getPlantData() {
        String[][] plantData = new String[0][];
        Read read = new Read();
        try {
            plantData = read.read(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return plantData;
    }

}
