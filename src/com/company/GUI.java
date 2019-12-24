package com.company;
import java.awt.*;
import java.awt.event.*;

public class GUI extends Frame{
GUI() {
    //Will likely recode into swing

    //makes a frame for everything
    Frame f = new Frame();
    f.setSize(400, 400);

    //testing of MenuBar to change menus
    MenuBar mb = new MenuBar();
    Menu menu = new Menu("Menu");
    MenuItem i1 = new MenuItem("Home");
    //makes menu buttons do stuff
    i1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //Can close the previous window
            f.dispose();
            //Reopens the home page
            GUI q = new GUI();
        }
    });
    MenuItem i2 = new MenuItem("Best Teams");
    i2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //Can close the previous window
            f.dispose();
            //Will open the best team choice page
            GUI q = new GUI();
        }
    });
    MenuItem i3 = new MenuItem("Individual Teams");
    i3.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //Can close the previous window
            f.dispose();
            //Will open the individual team page
            GUI q = new GUI();
        }
    });
    menu.add(i1);
    menu.add(i2);
    menu.add(i3);
    mb.add(menu);

    //testing text fields
    TextField tf = new TextField();
    tf.setBounds(50,50, 150,20);

    //test button with actions
    Button b = new Button("click me");
    b.setBounds(50,100,60,30);
    b.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            tf.setText("YEET I BE TESTING");
        }
    });
    //adding stuff to the frame and making it visible
    f.setMenuBar(mb);
    f.add(b);
    f.add(tf);
    f.setLayout(null);
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