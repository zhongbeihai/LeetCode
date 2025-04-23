package com.dynamic_programming;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes_354 {
    public int maxEnvelopes(int[][] envelopes) {
        // i envelop having dp[i] inside
        int[] dp = new int[envelopes.length];
        //dp[i] = dp[closest small envelops] + 1;


        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                // 首先比较int[i][0]的值
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                // 如果int[i][0]的值相等，则比较int[i][1]的值
                return Integer.compare(b[1], a[1]);
            }
        });

        int numberOfHeap = 0;
        for(int[] envelope: envelopes){
            int height = envelope[1];

            int left = 0, right = numberOfHeap;
            while (left < right){
                int mid = (left + right) / 2;
                if(dp[mid] < height){
                    left = mid + 1;
                }else {
                    right = mid;
                }
            }

            dp[left] = height;
            if(left == numberOfHeap){
                numberOfHeap++;
            }
        }


        return numberOfHeap;
    }

    public static void main(String[] args) {
        RussianDollEnvelopes_354 r = new RussianDollEnvelopes_354();
        r.maxEnvelopes(new int[][]{{4,5},{4,6},{6,7},{2,3},{1,1}});
    }
}
