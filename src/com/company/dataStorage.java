package com.company;

public class dataStorage {

    //This file will be used to move data to different files because I set up stuff bad
    //variables
    public static int [] teamList;

   public void teamListFiltered(int [] a) {
       teamList = new int[a.length];
       System.arraycopy(a,0,teamList,0,a.length);
   }
}
