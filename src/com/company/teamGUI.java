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

        TextField autonPercentField = new TextField();
        autonPercentField.setBounds(310,115, 50,20);
        f.add(autonPercentField);

        TextField autonBallAvgField = new TextField();
        autonBallAvgField.setBounds(310,135, 50,20);
        f.add(autonBallAvgField);

        TextField autonBallDevField = new TextField();
        autonBallDevField.setBounds(310,155, 50,20);
        f.add(autonBallDevField);

        TextField BallAvgField = new TextField();
        BallAvgField.setBounds(310,175, 50,20);
        f.add(BallAvgField);

        TextField BallDevField = new TextField();
        BallDevField.setBounds(310,195, 50,20);
        f.add(BallDevField);
        //
        //Labels for the data boxes
        //
        //
        Label TeamNames  = new Label();
        TeamNames.setText("Team Names");
        TeamNames.setBounds(22,55,80,20);
        f.add(TeamNames);

        Label Average = new Label();
        Average.setText("Average Score:");
        Average.setBounds(200,75, 100,20);
        f.add(Average);

        Label Deviation = new Label();
        Deviation.setText("Standard Deviation of Average:");
        Deviation.setBounds(120,95, 180,20);
        f.add(Deviation);

        Label autonPercent = new Label();
        autonPercent.setText("Percent Time does Autonomous:");
        autonPercent.setBounds(110,115, 190,20);
        f.add(autonPercent);

        Label autonBallAvg = new Label();
        autonBallAvg.setText("Average Balls scored in Auton:");
        autonBallAvg.setBounds(110,135, 190,20);
        f.add(autonBallAvg);

        Label autonBallDev = new Label();
        autonBallDev.setText("Standard Dev of Ball Avg in Auton:");
        autonBallDev.setBounds(110,155, 190,20);
        f.add(autonBallDev);

        Label BallAvg = new Label();
        BallAvg.setText("Average Balls scored:");
        BallAvg.setBounds(110,175, 190,20);
        f.add(BallAvg);

        Label BallDev = new Label();
        BallDev.setText("Standard Dev of Balls scored:");
        BallDev.setBounds(110,195, 190,20);
        f.add(BallDev);

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

                double autonPercent [] = new double[dataLocscount];
                stdDevArryCount = 0;
                countForLoop = 0;
                for (int a:dataLocs) {
                    if (a == 1) {
                        autonPercent[stdDevArryCount] = autontrue[countForLoop];
                        stdDevArryCount++;
                    }
                    countForLoop++;
                }
                autonPercentField.setText(Double.toString(toProcess.percent(autonPercent)));

                double ballScoreAvgData [] = new double[dataLocscount];
                stdDevArryCount = 0;
                countForLoop = 0;
                for (int a:dataLocs) {
                    if (a == 1) {
                        ballScoreAvgData[stdDevArryCount] = autonBall[countForLoop];
                        stdDevArryCount++;
                    }
                    countForLoop++;
                }
                autonBallAvgField.setText(Double.toString(toProcess.averageDouble(ballScoreAvgData)));

                double ballAvgArry [] = new double[dataLocscount];
                stdDevArryCount = 0;
                countForLoop = 0;
                for (int a:dataLocs) {
                    if (a == 1) {
                        ballAvgArry[stdDevArryCount] = ballsScored[countForLoop];
                        stdDevArryCount++;
                    }
                    countForLoop++;
                }
                BallAvgField.setText(Double.toString(toProcess.averageDouble(ballAvgArry)));

                double ballDevArry [] = new double[dataLocscount];
                stdDevArryCount = 0;
                countForLoop = 0;
                for (int a:dataLocs) {
                    if (a == 1) {
                        ballDevArry[stdDevArryCount] = ballsScored[countForLoop];
                        stdDevArryCount++;
                    }
                    countForLoop++;
                }
                BallDevField.setText(Double.toString(toProcess.averageDouble(ballDevArry)));

                dataLocscount = 0;
                double totalScore = 0;
                double numOfMatches = 0;
                for (int a:dataLocs) {
                    if (a == 1) {
                        totalScore+= teamScore[dataLocscount];
                        numOfMatches++;
                    }
                    dataLocscount++;
                }
                AverageScore.setText(Double.toString(totalScore/numOfMatches));

                double stdDevArryBall [] = new double[dataLocscount];
                stdDevArryCount = 0;
                countForLoop = 0;
                for (int a:dataLocs) {
                    if (a == 1) {
                        stdDevArryBall[stdDevArryCount] = autonBall[countForLoop];
                        stdDevArryCount++;
                    }
                    countForLoop++;
                }
                autonBallDevField.setText(Double.toString(toProcess.calculateSD(stdDevArryBall)));
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
