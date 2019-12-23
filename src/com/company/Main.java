package com.company;
import java.io.File;


public class Main {

    public static void main(String[] args) {
        //makes the GUI
        GUI q = new GUI();
        //Add folder generation for specific name if does not exist


        //Reads the files from a folder that is in the same location as the jar file
        String jarLoc = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        //Need to change folder name for release
        File file = new File(jarLoc + "/Test files/");
        File[] files = file.listFiles();
        for(File f: files){
            System.out.println(f.getName());
        }
    }
}
