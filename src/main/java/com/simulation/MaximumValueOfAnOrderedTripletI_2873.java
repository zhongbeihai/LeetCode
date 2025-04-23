package com.simulation;

public class MaximumValueOfAnOrderedTripletI_2873 {
    public long maximumTripletValue(int[] nums) {
        long maxTriplet = 0, maxDiff = 0, max = 0;
        for (int num:nums){
            maxTriplet = Math.max(maxTriplet, maxDiff * num);
            max = Math.max(max, num);
            maxDiff = Math.max(maxDiff, max - num);

        }

        return maxTriplet;
    }

    public static void main(String[] args) {
        MaximumValueOfAnOrderedTripletI_2873 m = new MaximumValueOfAnOrderedTripletI_2873();
        m.maximumTripletValue(new int[]{2,3,1});
    }
}
