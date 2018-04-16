package com.example.abrar.foresterapp;

import android.os.Bundle;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class Forum {

    static int plantResult;
    static ArrayList<Integer> plantsLocation;

    public static void findBestResult(String[] plants) {


        // sends all the characteristics to the experts
        ArrayList<Integer> results1 = leafShapeExpert.searchPlants(plants[0]);
        ArrayList<Integer> results2 = petalNumberExpert.searchPlants(plants[1]);
        ArrayList<Integer> results3 = petalColourExpert.searchPlants(plants[2]);
        ArrayList<Integer> results4 = petalSeparateExpert.searchPlants(plants[3]);
        ArrayList<Integer> results5 = fruitTypeExpert.searchPlants(plants[4]);
        ArrayList<Integer> results6 = leafletSimpleExpert.searchPlants(plants[5]);
        ArrayList<Integer> results7 = leafLengthExpert.searchPlants(plants[6]);

        ArrayList<Integer> arr1 = mostCommonPlant(results1, results7, results6);
        ArrayList<Integer> arr2 = mostCommonPlant(results2, results3, results4, results5);
        ArrayList<Integer> finalResult = new ArrayList<Integer>();

        finalResult = intersection(arr1, arr2);
        if (finalResult.isEmpty()){
            plantResult = 0;
        }
        else{
            plantResult = finalResult.get(0);}

    }

    public static void findByLocation(String location) {

        ArrayList<Integer> locRes = locationExpert.searchPlants(location);

        ArrayList<Integer> allPlants = new ArrayList<Integer>();
        int maxPlantSize = 7;
        for (int i = 1; i <= maxPlantSize;i++){
            allPlants.add(i);
        }

        plantsLocation = intersection(allPlants, locRes);

    }

    public static ArrayList<Integer> mostCommonPlant (ArrayList<Integer>... arrays){

        ArrayList<Integer> combined = new ArrayList<Integer>();
        for (ArrayList<Integer> array: arrays) {
            combined.addAll(array);
        }
        int count= 0;
        int num = 1, tempCount;
        int plant = combined.get(0);
        int temp = 0;
        for (int i = 0; i < (combined.size() - 1); i++) {
            temp = combined.get(i);
            tempCount = 0;
            for (int j = 1; j < combined.size(); j++) {
                if (temp == combined.get(j))
                    tempCount++;
            }
            if (tempCount > count) {
                plant = temp;
                num = tempCount;
            }}
            return combined;
    }


    public static <T> ArrayList<T> intersection(List<T> list1, List<T> list2) {
        ArrayList<T> list = new ArrayList<T>();

        for (T t : list1) {
            if(list2.contains(t)) {
                list.add(t);
            }
        }

        return list;
    }

}


