package com.simulation;



public class AverageWaitingTime_1701 {
    public double averageWaitingTime(int[][] customers) {
        long finishedTime = 0;
        long waitedTime = 0;
        for (int[] customer : customers) {
            if(finishedTime <= customer[0]){
                finishedTime = customer[0] + customer[1];
            }else {
                finishedTime += customer[1];
            }
            waitedTime += finishedTime - customer[0];
        }
        return (double)waitedTime / customers.length;
    }
}
