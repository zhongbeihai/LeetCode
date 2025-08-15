package com.simulation;


public class PowerOfFour_342 {
    public boolean isPowerOfFour(int n) {
        if (n == 0) return false;

        double d = n;
        while (d > 4){
            d /= 4.0;
        }

        return d == 1.0;
    }
}
