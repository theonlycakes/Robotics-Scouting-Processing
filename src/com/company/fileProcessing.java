package com.company;

import java.io.*;
import java.util.*;

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

        //makes a new array to put in list
        int tempArray [] = new int[teamName.length];
        int copyCount = 0;
            for (String toCopy: teamName) {
                tempArray[copyCount] = Integer.parseInt(toCopy);
            copyCount++;
        }

        //Remove the duplicate team names from teamName array for the list in teamGUI
        // creating List from array
        List<Integer> numList = new ArrayList<Integer>();
        for(int i : tempArray){
            numList.add(i);
        }
        Set<Integer> set = new LinkedHashSet<Integer>(numList);
        // Putting elements back in array
        int[] teamNameList = new int[set.size()];
        int j =0;
        for(int num:set){
            teamNameList[j++] = num;
        }


        //for printing array contents for test
        System.out.println(Arrays.toString(teamNameList));


    }
}
