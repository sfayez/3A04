package com.example.abrar.foresterapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class PageTwoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static String[] plantChar = new String[7];
    Spinner leafShapeSpinner;
    Spinner petalColourSpinner, petalNumberSpinner, petalSeparateSpinner;
    Spinner  fruitTypeSpinner;
    Spinner leafletSimpleSpinner;
    Spinner leafLengthSpinner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_two);

        leafShapeSpinner = findViewById(R.id.leafShapeSpinner);
        ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(this, R.array.leafShapes, android.R.layout.select_dialog_item);
        adapterOne.setDropDownViewResource(android.R.layout.simple_spinner_item);
        leafShapeSpinner.setAdapter(adapterOne);
        leafShapeSpinner.setOnItemSelectedListener(this);

        petalNumberSpinner = findViewById(R.id.petalNumberSpinner);
        ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(this, R.array.petalNumbers, android.R.layout.select_dialog_item);
        adapterTwo.setDropDownViewResource(android.R.layout.simple_spinner_item);
        petalNumberSpinner.setAdapter(adapterTwo);
        petalNumberSpinner.setOnItemSelectedListener(this);

        petalColourSpinner = findViewById(R.id.petalColourSpinner);
        ArrayAdapter<CharSequence> adapterThree = ArrayAdapter.createFromResource(this, R.array.petalColours, android.R.layout.select_dialog_item);
        adapterThree.setDropDownViewResource(android.R.layout.simple_spinner_item);
        petalColourSpinner.setAdapter(adapterThree);
        petalColourSpinner.setOnItemSelectedListener(this);

        petalSeparateSpinner = findViewById(R.id.petalSeparateSpinner);
        ArrayAdapter<CharSequence> adapterFour = ArrayAdapter.createFromResource(this, R.array.petalSeparate, android.R.layout.select_dialog_item);
        adapterFour.setDropDownViewResource(android.R.layout.simple_spinner_item);
        petalSeparateSpinner.setAdapter(adapterFour);
        petalSeparateSpinner.setOnItemSelectedListener(this);


        fruitTypeSpinner = findViewById(R.id.fruitTypeSpinner);
        ArrayAdapter<CharSequence> adapterFive = ArrayAdapter.createFromResource(this, R.array.fruitType, android.R.layout.select_dialog_item);
        adapterFive.setDropDownViewResource(android.R.layout.simple_spinner_item);
        fruitTypeSpinner.setAdapter(adapterFive);
        fruitTypeSpinner.setOnItemSelectedListener(this);


        leafletSimpleSpinner = findViewById(R.id.leafletSimpleSpinner);
        ArrayAdapter<CharSequence> adapterSix = ArrayAdapter.createFromResource(this, R.array.leafletSimple, android.R.layout.select_dialog_item);
        adapterSix.setDropDownViewResource(android.R.layout.simple_spinner_item);
        leafletSimpleSpinner.setAdapter(adapterSix);
        leafletSimpleSpinner.setOnItemSelectedListener(this);


        leafLengthSpinner = findViewById(R.id.leafLengthSpinner);
        ArrayAdapter<CharSequence> adapterSeven = ArrayAdapter.createFromResource(this, R.array.leafLength, android.R.layout.select_dialog_item);
        adapterSeven.setDropDownViewResource(android.R.layout.simple_spinner_item);
        leafLengthSpinner.setAdapter(adapterSeven);
        leafLengthSpinner.setOnItemSelectedListener(this);

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
    }
    public void onNothingSelected(AdapterView<?> arg0) {

    }

    public void sendChars(View v){

        String char1 = leafShapeSpinner.getSelectedItem().toString();
        plantChar[0] = char1;
        String char2 = petalNumberSpinner.getSelectedItem().toString();
        plantChar[1] = char2;
        String char3 = petalColourSpinner.getSelectedItem().toString();
        plantChar[2] = char3;
        String char4 = petalSeparateSpinner.getSelectedItem().toString();
        plantChar[3] = char4;
        String char5 = fruitTypeSpinner.getSelectedItem().toString();
        plantChar[4] = char5;
        String char6 = leafletSimpleSpinner.getSelectedItem().toString();
        plantChar[5] = char6;
        String char7 = leafLengthSpinner.getSelectedItem().toString();
        plantChar[6] = char7;

        Forum.findBestResult(plantChar);

        startActivity(new Intent(this, resultsPage.class));
    }


}
