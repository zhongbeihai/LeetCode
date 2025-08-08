package com.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        int len = nums.length;
        for (int i = 0; i < len - 2; i++){
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1, right = len - 1;
            while (left < right){
                if (nums[left] + nums[right] + nums[i] == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (nums[left] + nums[right] + nums[i] < 0) {
                    left++;
                } else if (nums[left] + nums[right] + nums[i] > 0) {
                    right--;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        ThreeSum_15 t = new ThreeSum_15();
        t.threeSum(new int[]{-1,0,1,2,-1,-4});
    }
}
