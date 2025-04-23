package com.stack;

public class MaximumChunksToMakeSorted_769 {
    public int maxChunksToSorted(int[] arr) {
        int res = 0;
        int p = 1;
        int count = 1;
        while (p < arr.length){
            if (arr[p] < arr[p - 1]){
                res += count;
                count = 0;
            }else {
                count++;
            }
            p++;
        }
        res += count;
        return res;
    }

    public static void main(String[] args) {
        MaximumChunksToMakeSorted_769 m = new MaximumChunksToMakeSorted_769();
        m.maxChunksToSorted(new int[]{1,0,2,3,4});
    }
}
