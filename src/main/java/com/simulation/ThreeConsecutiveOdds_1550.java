package com.simulation;

public class ThreeConsecutiveOdds_1550 {
    public boolean threeConsecutiveOdds(int[] arr) {
        int odds = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) odds++;
            else  odds = 0;
            if (odds == 3) return true;
        }
        return false;
    }
}
