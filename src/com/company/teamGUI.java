package com.company;

import java.awt.*;

import java.awt.event.*;

import static com.company.dataStorage.*;


public class teamGUI {
    teamGUI() {
        //Will likely recode into swing
        //Currently is just a copy of GUI
        //Will display the individual teams and their stats

        //GUI Items

        //makes a frame for everything
        Frame f = new Frame();
        f.setSize(400, 400);
        //Creates an object for the data processing
        processData toProcess = new processData();
        //Textfields for data
        TextField AverageScore = new TextField();
        AverageScore.setBounds(310,75, 50,20);
        f.add(AverageScore);
        TextField StdDev = new TextField();
        StdDev.setBounds(310,95, 50,20);
        f.add(StdDev);
        //Labels for the data boxes
        Label Average = new Label();
        Average.setText("Average Score:");
        Average.setBounds(200,75, 100,20);
        f.add(Average);
        Label Deviation  = new Label();
        Deviation.setText("Standard Deviation:");
        Deviation.setBounds(180,95, 120,20);
        f.add(Deviation);
        //list for selecting the teams
        List teamlist = new List (teamList.length);
        teamlist.setBounds(25,75,75,225);
        for (int listadding: teamList) {
            teamlist.add(Integer.toString(listadding));
        }
        teamlist.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                //data processing/sending to other locations
                int indexOfClicked = teamlist.getSelectedIndex();
                int valOfClicked = teamList[indexOfClicked];
                int dataLocs [] = new int[teamName.length];
                int dataLocscount = 0;
                for (int a:teamName) {
                    if (valOfClicked == a) {
                        dataLocs[dataLocscount] = 1;
                    }
                    else {
                        dataLocs[dataLocscount] = 0;
                    }
                    dataLocscount++;
                }
                double stdDevArry [] = new double[dataLocscount];
                int stdDevArryCount = 0;
                int countForLoop = 0;
                for (int a:dataLocs) {
                    if (a == 1) {
                        stdDevArry[stdDevArryCount] = teamScore[countForLoop];
                        stdDevArryCount++;
                    }
                    countForLoop++;
                }
                StdDev.setText(Double.toString(toProcess.calculateSD(stdDevArry)));
                dataLocscount = 0;
                int totalScore = 0;
                int numOfMatches = 0;
                for (int a:dataLocs) {
                    if (a == 1) {
                        numOfMatches++;
                        totalScore+= teamScore[dataLocscount];
                        numOfMatches++;
                    }
                    dataLocscount++;
                }
                //GUI elements that are made on press
                AverageScore.setText(Double.toString(totalScore/numOfMatches));
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
        //test button with actions


        //adding stuff to the frame and making it visible
        f.add(teamlist);
        f.setMenuBar(mb);
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
