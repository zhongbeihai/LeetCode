package com.simulation;

public class WaterBottles_1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = 0, empty = 0;
        while ((empty + numBottles) / numExchange > 0){
            res += numBottles;
            empty += numBottles;
            numBottles = empty / numExchange;
            empty = empty % numExchange;
        }


        return res + numBottles;
    }

    public static void main(String[] args) {
        WaterBottles_1518 w = new WaterBottles_1518();
        w.numWaterBottles(9, 3);
    }
}
