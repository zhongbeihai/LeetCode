package com.simulation;

public class PowerOfThree_326 {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;

        double d = n;
        while (d > 1){
            d /= 3.0;
        }

        return d == 1;
    }
}
