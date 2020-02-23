package com.company;

public class processData {
    //This file is used to be a central location for processing the data in different ways
    processData(){
        //This does nothing for now at least
    }
    public double average(int data[]) {
        //Gives the average of a numerical data array
        double total = 0;
        double count = 0;
        for (int adding: data) {
            count++;
            total+=adding;
        }
        return (total/count);
    }

    public double averageDouble(double data[]) {
        //Gives the average of a numerical data array
        double total = 0;
        double count = 0;
        for (double adding: data) {
            count++;
            total+=adding;
        }
        return (total/count);
    }

    public double calculateSD(double numArray[]) {
        //calculate standard deviation
        double sum = 0.0, standardDeviation = 0.0;
        int length = numArray.length;

        for(double num : numArray) {
            sum += num;
        }

        double mean = sum/length;

        for(double num: numArray) {
            standardDeviation += Math.pow(num - mean, 2);
        }

        return Math.sqrt(standardDeviation/length);
    }

    public double percent(double data[]) {
        //calculates percent times happened
        double trueCount = 0;
        double totalCount = 0;
        for (double a: data) {
            if (a > 0) {
                trueCount++;
            }
            totalCount++;
        }
        return (trueCount/totalCount);
    }

}
