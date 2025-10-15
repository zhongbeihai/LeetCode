package com.simulation;

import java.util.List;

public class AdjacentIncreasingSubarraysDetectionII_3350 {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int[] L = new int[n], R = new int[n];
        L[0] = 1;
        R[n - 1] = 1;
        for (int i = 1; i < n; i++){
            L[i] = nums.get(i) > nums.get(i - 1) ? L[i - 1] + 1 : 1; // Strictly increasing segment length ending in i
        }
        for (int i = n - 2; i >= 0; i--){
            R[i] = nums.get(i) < nums.get(i + 1) ? R[i + 1] + 1 : 1; // Strictly increasing segment length starting in i
        }

        int l = 0, r = n / 2;
        while (l < r){
            int mid = (l + r) >>> 1;
            if (validK(L, R, mid)){
                l = mid;
            }else {
                r = mid - 1;
            }
        }

        return l;
    }

    public boolean validK(int[] L, int[] R, int k){
        int n = L.length;

        for (int i = 1; i < n; i++){
            if (L[i - 1] >= k && R[i] >= k) return true;
        }

        return false;
    }
}
