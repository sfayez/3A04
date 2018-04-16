package com.example.abrar.foresterapp;

import java.util.ArrayList;

public class leafLengthExpert {/* Range type expert */

    public static ArrayList<Integer> searchPlants(String value){
        // use 'type' // -- value -- // to find all the plants that match the specific characteristic
        ArrayList<Integer> bestPlants = new ArrayList<Integer>();
        //int column = 14; //the appropriate column for this expert!
        if (value.equals("N/A")) { //case for when user does not enter a value
            bestPlants.add(0);
            return bestPlants;
        }
        String[][] plantData = Plant.getPlants("leafLength"); //get data from database

        /* expert decides on best plants */
        for (int i = 0; i < plantData.length; i++) {
            int min = Integer.parseInt(plantData[i][1].split("-")[0]);
            int max = Integer.parseInt(plantData[i][1].split("-")[1]);
            if ((min <= Integer.parseInt(value)) && (Integer.parseInt(value) <= max)){
                bestPlants.add(Integer.parseInt(plantData[i][0]));
            }

        }
        // return a list of all plants that match that character
        return bestPlants;
    }


}
