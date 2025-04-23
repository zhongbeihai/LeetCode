package com.prefixsum;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * You are given a 0-indexed integer array nums.
 * There exists an array arr of length nums.length,
 * where arr[i] is the sum of |i - j| over all j such that nums[j] == nums[i] and j != i.
 * If there is no such j, set arr[i] to be 0.
 * Input: nums = [1,3,1,1,2]
 * Output: [5,0,3,4,0]
 * When i = 0, nums[0] == nums[2] and nums[0] == nums[3]. Therefore, arr[0] = |0 - 2| + |0 - 3| = 5.
 *  **前缀和**
 *  当前点sum = 上一个相同值点sum + 当前线段数目 * 当前点到上一个点距离
 */
public class SumOfDistance_2615 {
    public long[] distance(int[] nums) {
        //<nums[i], <sum, i>>
        HashMap<Integer, LinkedList<Pair<Long, Integer>>> g = new HashMap<>();
        long res[] = new long[nums.length];
        // scan to the left
        for (int i = 0; i < nums.length; i++) {
            long curSum = 0;
            if (g.get(nums[i]) != null) {
                // 当前点sum = 上一个相同值点sum + 当前线段数目 * 当前点到上一个点距离
                curSum += g.get(nums[i]).getLast().getKey() +
                        (long) Math.abs(i - g.get(nums[i]).getLast().getValue()) * g.get(nums[i]).size();

            }
            res[i] += curSum;
            if (g.get(nums[i]) == null) {
                g.put(nums[i], new LinkedList<>());
            }
            g.get(nums[i]).addLast(new Pair<>(curSum, i));
            // 1 -> <0,0>, <2,2>, <3,3>
        }

        g.clear();

        // scan to the right
        for(int i = nums.length - 1; i >=0 ; i--){
            long curSum = 0;
            if (g.get(nums[i]) != null) {
                // 当前点sum = 上一个相同值点sum + 当前线段数目 * 当前点到上一个点距离
                curSum += g.get(nums[i]).getLast().getKey() +
                        (long) Math.abs(i - g.get(nums[i]).getLast().getValue()) * g.get(nums[i]).size();

            }
            res[i] += curSum;
            if (g.get(nums[i]) == null) {
                g.put(nums[i], new LinkedList<>());
            }
            g.get(nums[i]).addLast(new Pair<>(curSum, i));
        }

        System.out.println(Arrays.toString(res));
        return res;
    }

    public static void main(String[] args) {
        SumOfDistance_2615 s = new SumOfDistance_2615();
        s.distance(new int[]{1,3,1,1,2});
    }
}
