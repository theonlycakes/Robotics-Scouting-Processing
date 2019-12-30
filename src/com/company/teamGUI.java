package com.company;

import java.awt.*;

import java.awt.event.*;

import static com.company.dataStorage.teamList;
import static com.company.dataStorage.teamName;


public class teamGUI {
    teamGUI() {
        //Will likely recode into swing
        //Currently is just a copy of GUI
        //Will display the individual teams and their stats

        //GUI Items

        //makes a frame for everything
        Frame f = new Frame();
        f.setSize(400, 400);

        //list for selecting the teams
        List teamlist = new List (teamList.length);
        teamlist.setBounds(50,100,75,75);
        for (int listadding: teamList) {
            teamlist.add(Integer.toString(listadding));
        }
        teamlist.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                //data processing/sending to other locations
                int indexOfClicked = teamlist.getSelectedIndex();
                int valOfClicked = teamList[indexOfClicked];
                int dataLocs [] = new int[teamName.length];
                for (int a:teamName) {
                    if (valOfClicked == a) {

                    }
                }
                //GUI elements that are made on press
            }
        });
        //Menu bar is used to execute
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
        tf.setText("This box does nothing!!!!!");
        //test button with actions


        //adding stuff to the frame and making it visible
        f.add(teamlist);
        f.setMenuBar(mb);
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
