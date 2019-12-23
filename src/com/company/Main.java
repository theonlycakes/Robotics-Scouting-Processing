package com.company;
import java.io.File;



public class Main {

    public static void main(String[] args) {
        //makes the GUI
        GUI q = new GUI();
        //gets location of jar file
        String jarLoc = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();

        //Makes a folder to add the data to which it can read from
        File dir = new File(jarLoc + "Scouting Data");
        dir.mkdir();
        //Reads the files from a folder that is in the same location as the jar file
        //Need to change folder name for release
        File file = new File(jarLoc + "/Scouting Data/");
        File[] files = file.listFiles();
        for(File f: files){
            System.out.println(f.getName());
        }
    }
}
