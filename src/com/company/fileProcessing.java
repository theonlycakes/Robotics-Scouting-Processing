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
        String teamName [] = new String[files.length]; //Team name
        int matchName [] = new int[files.length]; //Match number
        int auton [] = new int[files.length]; //Did the team do autonomous (1 for yes or 0 for no)
        int autonBallScore [] = new int[files.length]; //Number of balls scored during autonomous period
        int ballScore [] = new int[files.length]; // Number of balls scored during the non autonomous period
        String teamScore [] = new String[files.length]; // Overall score of the alliance
        int fortune [] = new int[files.length]; // Did the team spin the wheel or not ( 2 for color 1 for spin or 0 for no)
        int playPos [] = new int[files.length]; // What did the team play (0 for Mixed 1 for Offence 2 for Defense
        int broke [] = new int[files.length]; // Did the robot break (0 for no 1 for yes)
        int reason [] = new int[files.length]; //Reason if Robot broke(
        int endPos [] = new int[files.length]; // The end position of the robot (0 for no points 1 for under the tower thing 2 for hanging 3 for a balanced hang)
        //reads the data from the file and stores in correct location
        int numFile = -1;
            for(File f: files) {
                numFile++;
                File curFile = new File(String.valueOf(f.getAbsoluteFile()));
                Scanner dataRead = new Scanner(curFile);
                while (dataRead.hasNext()) {
                    storageString = dataRead.next();
                    //System.out.println(storageString);
                }
                //splits the string by commas reason csv
                tempStorage = storageString.split(",");
                //Data added to the arrays in order that the files are read
                teamName[numFile] = tempStorage[0];
                matchName[numFile] = Integer.parseInt(tempStorage[1]);
                auton[numFile] = Integer.parseInt(tempStorage[2]);
                autonBallScore[numFile] = Integer.parseInt(tempStorage[3]);
                ballScore[numFile] = Integer.parseInt(tempStorage[4]);
                teamScore[numFile] = tempStorage[5];
                fortune[numFile] = Integer.parseInt(tempStorage[6]);
                playPos[numFile] = Integer.parseInt(tempStorage[7]);
                broke[numFile] = Integer.parseInt(tempStorage[8]);
                reason[numFile] = Integer.parseInt(tempStorage[9]);
                endPos[numFile] = Integer.parseInt(tempStorage[10]);
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
        //testing this to move data
        dataStorage toData = new dataStorage();
        toData.teamListFiltered(teamNameList);
        toData.teamName(teamName);
        toData.teamScore(teamScore);
        toData.setAutontrue(auton);
        toData.setautonBall(autonBallScore);
        toData.setballsScored(ballScore);
        //for printing array contents for test
        //System.out.println(Arrays.toString(teamNameList));


    }
}
