package com.search;

public class HouseRobber_2560 {
    public int minCapability(int[] nums, int k) {
        int low = 1, high = 0;
        for (int num: nums){
            high = Math.max(high, num);
        }

        while (low < high){
            int mid = low + (high - low) / 2;
            if (steal(nums, k, mid)){
                high = mid;
            }else {
                low = mid + 1;
            }
        }

        return low;
    }

    public boolean steal(int[] nums, int k, int minDiff){
        int lastStolen = -2;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] <= minDiff && i > lastStolen + 1){
                k--;
                lastStolen = i;
                if (k == 0) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        HouseRobber_2560 h = new HouseRobber_2560();
        h.minCapability(new int[]{2,3,5,9}, 2);
    }
}
