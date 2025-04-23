package com.dynamic_programming;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class DestroyingAsteroids_2126 {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        if (asteroids.length == 1) return mass >= asteroids[0];
        Arrays.sort(asteroids);
        int p = 0;
        long m = mass;
        while (p < asteroids.length){
            if (asteroids[p] <= mass){
                m += asteroids[p];
                p++;
            }else break;
        }

        return p == asteroids.length;
    }

    public static void main(String[] args) {
        DestroyingAsteroids_2126 d = new DestroyingAsteroids_2126();
        //d.asteroidsDestroyed(10, new int[]{3,9,19,5,21});
        d.asteroidsDestroyed(156, new int[]{33,120,177,108,83,9,57,56,103,92,185,128,103,150,9,191,142,177,76,143,163,93,151,62,146,26,123,12,183,18,53,196,116,110,103,49,183,15,144,137,78,193,159,30,72,89,156,15,104,144,181,6,70,156,79,82,56,74,155,107,167,60,18,39,75,96,193,158,133,40,197,38,9,186,10,184,71,141,157,29,81,170,95,154,35,66,101,101,162,22,192,148,161,35,35,107,83,123,59,152});
    }
}
