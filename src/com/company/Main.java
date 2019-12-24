package com.company;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        //gets location of jar file
        String jarLoc = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        //Makes a folder to add the data to which it can read from
        File dir = new File("Scouting Data");
        dir.mkdir();
        //Reads the files from a folder that is in the same location as the jar file
        //Will be changed to run on button so the user can add data
        File file = new File("Scouting Data");
        File[] files = file.listFiles();
        for(File f: files){
            System.out.println(f.getName());
        }

        //makes the GUI
        GUI q = new GUI();

    }
}
