package com.company;
import java.awt.*;
import java.awt.event.*;

public class GUI extends Frame{
GUI() {
    Frame f = new Frame();
    f.setSize(300, 300);
    Button b = new Button("click me");
    f.add(b);


    f.setVisible(true);
    //allows the program to be closed
    f.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    });
    }
}