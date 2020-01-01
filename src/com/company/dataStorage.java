package com.company;

public class dataStorage {

    //This file will be used to move data to different files because I set up stuff bad
    //Also will change the arrays from strings to int
    //Names in this file will be a mess don't question

    //variables
    public static int [] teamList;
    public static int[] teamName;
    public static int[] teamScore;

   public void teamListFiltered(int [] a) {
       teamList = new int[a.length];
       System.arraycopy(a,0,teamList,0,a.length);
   }
   public void teamName(String a[]) {
        teamName = new int[a.length];
        int count = 0;
        for (String change: a) {
            teamName[count] = Integer.parseInt(change);
            count++;
        }
    }
    public void teamScore(String a[]) {
        teamScore = new int[a.length];
        int count = 0;
        for (String change: a) {
            teamScore[count] = Integer.parseInt(change);
            count++;
        }
    }
}
