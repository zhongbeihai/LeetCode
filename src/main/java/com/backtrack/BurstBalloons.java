package com.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BurstBalloons {
    private int cnt = 0;
    public int maxCoins(int[] nums) {
        List<Integer> l = new ArrayList<>();
        for(int num : nums){
            l.add(num);
        }
        backTracking(l, 0);
        return cnt;
    }

    public void backTracking(List<Integer> nums, int count) {
        if(nums.isEmpty()){
            if (count > cnt) cnt = count;
            return;
        }

        for(int i = 0; i < nums.size(); i++) {
            int tem = nums.get(i);
            if (i - 1 >= 0){
                tem = tem * nums.get(i - 1);
            }
            if(i + 1 < nums.size()){
                tem = tem * nums.get(i + 1);
            }
            count += tem;
            List<Integer> newNums = new ArrayList<>(nums);
            newNums.remove(i);
            backTracking(newNums, count);
            count -= tem;
        }
    }

    public static void main(String[] args) {
        BurstBalloons n = new BurstBalloons();
        n.maxCoins(new int[]{3,1,5,8});
    }
}
