package com.simulation;

public class KthMissingPositiveNumber_1539 {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        if (arr[n - 1] - n < k) return k + n;
        int cnt = 1, ind = 0;
        while (k > 0){
            if (arr[ind] == cnt){
                ind++;
            }else {
                k--;
            }
            cnt++;
        }

        return cnt - 1;
    }

    public static void main(String[] args) {
        KthMissingPositiveNumber_1539 k = new KthMissingPositiveNumber_1539();
        k.findKthPositive(new int[]{5,6,7,8,9}, 9);
    }
}
