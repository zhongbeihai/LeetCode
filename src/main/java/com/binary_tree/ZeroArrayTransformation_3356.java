package com.binary_tree;

import structure.Pair;

import javax.swing.*;
import java.util.Arrays;

public class ZeroArrayTransformation_3356 {
    public int minZeroArray(int[] nums, int[][] queries) {
        int left = 0, right  = queries.length - 1;
        if (Arrays.stream(nums).allMatch(x -> x == 0)) return 0;
        if (!canMakeZeroArray(right, nums, queries)) return -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canMakeZeroArray(mid, nums, queries)){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    public int newWay(int[] nums, int[][] queries) {
        for (int i = 0; i < queries.length; i++){
            for (int j = queries[i][0]; j <= queries[i][1]; j++){
                if (nums[j] == 0) continue;
                if (queries[i][2] < nums[j]) nums[j] -= queries[i][2];
                else nums[j] = 0;
            }
            if (Arrays.stream(nums).allMatch(x -> x == 0)) return i + 1;
        }

        return -1;
    }

    private boolean canMakeZeroArray(int k, int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        for (int i = 0; i < k; i++) {
            int left = queries[i][0], right = queries[i][1], val = queries[i][2];
            diff[left] += val;
            diff[right + 1] -= val;
        }
        int currVal = 0;
        for (int i = 0; i < n; i++) {
            currVal += diff[i];
            if (currVal < nums[i]) return false;
        }
        return true;
    }



    public static void main(String[] args) {
        ZeroArrayTransformation_3356 z = new ZeroArrayTransformation_3356();
        z.newWay(new int[]{2,0,2}, new int[][]{{0,2,1}, {0,2,1},{1,1,3}});
        //z.newWay(new int[]{4,3,2,1}, new int[][]{{1,3,2}, {0,2,1}});
        //z.minZeroArray(new int[]{0}, new int[][]{{0,0,2}, {0,0,4},{1,1,3}});
    }

}
