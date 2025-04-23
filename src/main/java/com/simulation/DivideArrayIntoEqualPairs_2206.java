package com.simulation;

public class DivideArrayIntoEqualPairs_2206 {

    public boolean divideArray(int[] nums) {
        int mask = 0;
        for (int i = 0; i < nums.length; i++){
            mask ^= (i >> 1);
        }

        return mask == 0;
    }

    public static void main(String[] args) {
        DivideArrayIntoEqualPairs_2206 d = new DivideArrayIntoEqualPairs_2206();
        d.divideArray(new int[]{1,2,3,4});
    }

}
