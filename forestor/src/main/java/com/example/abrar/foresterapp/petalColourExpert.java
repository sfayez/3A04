package com.example.abrar.foresterapp;

import java.util.ArrayList;

public class petalColourExpert {/* List type expert */

    public static ArrayList<Integer> searchPlants(String value){
        // use 'type' // -- value -- // to find all the plants that match the specific characteristic
        ArrayList<Integer> bestPlants = new ArrayList<Integer>();
        //int column = 8; //the appropriate column for this expert!
        if (value.equals("N/A")) { //case for when user does not enter a value
            bestPlants.add(0);
            return bestPlants;
        }

        String[][] plantData = Plant.getPlants("petalColour"); //get data from database
        String[] attributes;

        /* expert decides on best plants */
        for (int i = 0; i < plantData.length; i++) {
            attributes = plantData[i][1].split(";");

            for (int j = 0; j < attributes.length; j++) {
                if (attributes[j].equals(value)){
                    bestPlants.add(Integer.parseInt(plantData[i][0]));
                }
            }

        }
        // return a list of all plants that match that character
        return bestPlants;
    }


}
