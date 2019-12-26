package com.company;

import java.io.File;

public class fileCreator {
    fileCreator() {
        //Makes a folder to add the data to which it can read from
        File dir = new File("Scouting Data");
        dir.mkdir();
    }
}
