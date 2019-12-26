package com.company;

import java.io.File;

public class fileProcessing {
    void fileReader()  {
        //Reads the files from a folder that is in the same location as the jar file
        File file = new File("Scouting Data");
        //contains the names of all the files
        File[] files = file.listFiles();
        //lists the files to console for testing now
        for(File f: files){
            System.out.println(f.getName());
        }

    }
}
