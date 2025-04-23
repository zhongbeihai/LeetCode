package com.dynamic_programming;

public class IncreasingTripletSubsequence_334 {
    public boolean increasingTriplet(int[] nums) {

        int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE;

        for(int num: nums){
            if(num <= m1) {
                m1 = num;
            } else if (num <= m2) {
                m2 = num;
            }else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        IncreasingTripletSubsequence_334 i = new IncreasingTripletSubsequence_334();
        i.increasingTriplet(new int[]{2,1,5,0,4,6});
    }
}
