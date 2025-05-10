package com.greedy;

public class MinimumEqualSumOfTwoArraysAfterReplaceingZero_2918 {
    public long minSum(int[] nums1, int[] nums2) {
        long leftSum = 0, leftZeros = 0;
        for (int j : nums1) {
            leftSum += j;
            if (j == 0) leftZeros++;
        }
        long rightSum = 0, rightZeros = 0;
        for (int num: nums2){
            rightSum += num;
            if (num == 0) rightZeros++;
        }

        if ((leftZeros == 0 && leftSum < rightSum + rightZeros) || (rightZeros == 0 && rightSum < leftSum + leftZeros)) return -1;
        return Math.max(rightSum + rightZeros, leftSum + leftZeros);
    }

    public static void main(String[] args) {
        MinimumEqualSumOfTwoArraysAfterReplaceingZero_2918 m = new MinimumEqualSumOfTwoArraysAfterReplaceingZero_2918();
        m.minSum(new int[]{0,16,28,12,10,15,25,24,6,0,0}, new int[]{20,15,19,5,6,29,25,8,12});
    }
}
