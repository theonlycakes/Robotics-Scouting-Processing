package com.company;

import java.io.File;

public class fileProcessing {
    void fileReader(String loc)  {
        //Reads the files from a folder that is in the same location as the jar file
        //Will be changed to run on button so the user can add data
        File file = new File("Scouting Data");
        File[] files = file.listFiles();
        for(File f: files){
            System.out.println(f.getName());
        }

    }
}
