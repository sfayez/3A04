package com.example.abrar.foresterapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class resultsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_page);


        setContentView(R.layout.activity_results_page);
        TextView textView = (TextView) findViewById(R.id.results);
        if (Forum.plantResult == 0){
            textView.setText("No plants match the entered description");
        }
        else{
            textView.setText("The plant you are looking for is: "+ String.valueOf(Plant.getAttribute(Forum.plantResult, 1)) +
                    "\n common name: " +Plant.getAttribute(Forum.plantResult, 2));}


        // use plantResult to get plant picture from data and family characteristic
        if(Forum.plantResult == 1){
            ImageView image = (ImageView) findViewById(R.id.plantImg1);
            image.setVisibility(View.VISIBLE); }
        else if (Forum.plantResult == 2){
            ImageView image = (ImageView) findViewById(R.id.plantImg2);
            image.setVisibility(View.VISIBLE); }
        else if (Forum.plantResult == 3){
            ImageView image = (ImageView) findViewById(R.id.plantImg3);
            image.setVisibility(View.VISIBLE); }
        else if (Forum.plantResult == 4){
            ImageView image = (ImageView) findViewById(R.id.plantImg4);
            image.setVisibility(View.VISIBLE); }
        else if (Forum.plantResult == 5){
            ImageView image = (ImageView) findViewById(R.id.plantImg5);
            image.setVisibility(View.VISIBLE); }
        else if (Forum.plantResult == 6){
            ImageView image = (ImageView) findViewById(R.id.plantImg6);
            image.setVisibility(View.VISIBLE); }
        else if (Forum.plantResult == 7){
            ImageView image = (ImageView) findViewById(R.id.plantImg7);
            image.setVisibility(View.VISIBLE); }

    }

}
