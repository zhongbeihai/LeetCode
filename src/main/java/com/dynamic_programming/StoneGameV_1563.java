package com.dynamic_programming;

public class StoneGameV_1563 {
    public int stoneGameV(int[] stoneValue) {
        int[] prefixSum = new int[stoneValue.length + 1];
        for(int i = 1; i < prefixSum.length; i++){
            prefixSum[i] = prefixSum[i - 1] + stoneValue[i - 1];
        }

        int aliceBoundaryLeft = 0;
        int aliceBoundaryRight = 1;
        int different = Integer.MAX_VALUE;
        while (aliceBoundaryLeft < aliceBoundaryRight){
            int leftSum = prefixSum[aliceBoundaryRight] - prefixSum[aliceBoundaryLeft];
            int rightSum = prefixSum[prefixSum.length - 1] - prefixSum[aliceBoundaryRight];
            if(Math.abs(leftSum - rightSum) < different){
                different = Math.abs(leftSum- rightSum);
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        StoneGameV_1563 s = new StoneGameV_1563();
        s.stoneGameV(new int[]{6,2,3,4,5,5});
    }
}
