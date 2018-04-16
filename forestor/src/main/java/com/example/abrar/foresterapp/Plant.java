package com.example.abrar.foresterapp;

import java.util.ArrayList;

public class Plant {
    static String[][] plantData;

    public static void getData(String[][] dataset) {
        plantData = dataset;
    }

    public String[] getPlantById(int ID){
        return plantData[ID];
    }

    public static String getAttribute(int ID, int num){
        return plantData[ID-1][num];
    }

    public static String[][] getPlants(String attribute) {
        String[][] matchingPlants = new String[plantData.length-1][2]; //length-1 used because we don't want the title used

        int column = 0;
        switch(attribute) {
            case "fruitType":
                column = 4;
                break;
            case "petalNumber":
                column = 7;
                break;
            case "petalColour":
                column = 8;
                break;
            case "petalSeparate":
                column = 9;
                break;
            case "leafShape":
                column = 11;
                break;
            case "leafletSimple":
                column = 12;
                break;
            case "leafLength":
                column = 14;
                break;
            case "location":
                column = 15;
                break;
            default:
                System.out.print("error");
        }

        for (int j = 1; j < plantData.length; j++) {
            matchingPlants[j-1][0] = plantData[j][0]; //plantID
            matchingPlants[j-1][1] = plantData[j][column]; //desired attribute
            //j-1 shifts the array up 1, ignoring the title row
        }


        return matchingPlants;
    }

}
