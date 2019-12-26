package com.company;

import java.io.*;
import java.net.URLDecoder;
import java.nio.file.Paths;
import java.util.Scanner;

public class fileProcessing {
    void fileReader() throws FileNotFoundException {
        //Reads the files from a folder that is in the same location as the jar file
        File file = new File("Scouting Data");
        //contains the names of all the files
        File[] files = file.listFiles();
        //lists the files to console for testing now
        //Take all the data from the files
        String tempStorage [] = new String[11];
        String storageString = null;

            for(File f: files) {
                File curFile = new File(String.valueOf(f.getAbsoluteFile()));

                Scanner dataRead = new Scanner(curFile);
                while (dataRead.hasNext()) {
                    System.out.println(dataRead.next());
                    storageString = dataRead.next();
                }
                tempStorage = storageString.split(",");

            }


    }
}
