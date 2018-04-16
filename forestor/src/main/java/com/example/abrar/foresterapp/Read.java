package com.example.abrar.foresterapp;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class is to read plant data from the database.
 */

public class Read {

    /**
     * Constructor of the Read class.
     */

    public Read() {
    }

    /**
     * Read plant data from the database.
     * 
     * @param context - the context from main activity.
     * @return - data from the database
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static String[][] read(Context context) throws FileNotFoundException, IOException {
        String fileName = "plantdata.csv";
        InputStream is = context.getAssets().open(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        List<String> out = new ArrayList<>();
        String line;
        reader.readLine();
        while ((line = reader.readLine()) != null) {
            out.add(line);
        }
        System.out.println(out.toString());   // Print the string content read from the input stream
        reader.close();

        String[][] dataArr = new String[out.size()][18];
        for (int i = 0; i < out.size(); i++) {
            for (int j = 0; j < 18; j++) {
                dataArr[i][j] = out.get(i).split(",")[j];
            }
        }
        return dataArr;

    }
}
