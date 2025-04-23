package com.dequeue_and_priorityqueue;

import java.util.Arrays;

public class CheckNAndItsDoubleExist_1346 {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);

        int f = 0, r = 0;
        while (f < arr.length) {
            while (r + 1 < arr.length && arr[r] / arr[f] < 2){
                r++;
            }
            if(arr[f] != 0 && arr[r] / arr[f] == 2 && arr[r] % arr[f] == 0) return true;
            f++;
        }

        return false;
    }

    public static void main(String[] args) {
        CheckNAndItsDoubleExist_1346 c = new CheckNAndItsDoubleExist_1346();
        c.checkIfExist(new int[]{-2,-2,0,0,10,-19,4,6,-8});
    }
}
