package com.company;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        //gets location of jar file
        String jarLoc = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        //Makes the file
        fileCreator create = new fileCreator(jarLoc);
        //Makes the file processing object
        fileProcessing process = new fileProcessing();
        //temp reads the file will change to run from GUI on button press
        process.fileReader(jarLoc);
        //makes the GUI
        GUI q = new GUI();

    }
}
