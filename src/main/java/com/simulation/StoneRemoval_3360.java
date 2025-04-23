package com.simulation;

public class StoneRemoval_3360 {

    public boolean canAliceWin(int n) {
        if (n < 10) return false;
        int r = 10;
        int turns = 0;
        while (n >= r){
            n -= r;
            r--;
            turns++;
        }

        return turns % 2 == 1;
    }
}
