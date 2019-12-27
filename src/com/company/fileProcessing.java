package com.company;

import java.io.*;
import java.util.Scanner;

public class fileProcessing {
    void fileReader() throws FileNotFoundException {
        //Reads the files from a folder that is in the same location as the jar file
        File file = new File("Scouting Data");
        //contains the names of all the files
        File[] files = file.listFiles();
        //some temp vars for moving data to correct place
        String tempStorage [] = new String[15];
        String storageString = null;
        //arrays for the different information
        String teamName [] = new String[files.length];
        String matchName [] = new String[files.length];
        String startPos [] = new String[files.length];
        String ballScore [] = new String[files.length];
        String hatchScore [] = new String[files.length];
        String teamScore [] = new String[files.length];
        String oppoScore [] = new String[files.length];
        String playPos [] = new String[files.length];
        String broke [] = new String[files.length];
        String endPos [] = new String[files.length];
        //reads the data from the file and stores in correct location
        int numFile = -1;
            for(File f: files) {
                numFile++;
                File curFile = new File(String.valueOf(f.getAbsoluteFile()));
                Scanner dataRead = new Scanner(curFile);
                while (dataRead.hasNext()) {
                    storageString = dataRead.next();
                    System.out.println(storageString);
                }
                //splits the string by commas reason csv
                tempStorage = storageString.split(",");
                //Data added to the arrays in order that the files are read
                teamName[numFile] = tempStorage[0];
                matchName[numFile] = tempStorage[1];
                startPos[numFile] = tempStorage[2];
                ballScore[numFile] = tempStorage[3];
                hatchScore[numFile] = tempStorage[4];
                teamScore[numFile] = tempStorage[5];
                oppoScore[numFile] = tempStorage[6];
                playPos[numFile] = tempStorage[7];
                broke[numFile] = tempStorage[8];
                endPos[numFile] = tempStorage[9];
            }
        //End of data storage and separation

        //TODO
        //Remove the duplicate team names from teamName array for the list in teamGUI

    }
}
