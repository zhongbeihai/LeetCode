package com.doublepointers;

public class HouseRobberIV_2560 {
    public int minCapability(int[] nums, int k) {
        int low = nums[0], high = nums[0];
        for(int i : nums){
            low = Math.min(i, low);
            high = Math.max(i, high);
        }

        while (low < high){
            int cap = (low + high) / 2;
            if(check(nums, k, cap)){
                high = cap;
            }else {
                low = cap + 1;
            }
        }

        return high;
    }

    public boolean check(int[] nums, int k, int minDiff){
        int lastSeen = - 2;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= minDiff && i > lastSeen + 1) {
                lastSeen = i;
                k--;
                if(0 == k) return true;
            }
        }
        return false;
    }
}
