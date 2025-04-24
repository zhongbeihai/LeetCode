package com.sliding_windows;

import java.util.HashMap;
import java.util.HashSet;

public class CountCompleteSubarraysInAnArray_2799 {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums){
            set.add(num);
        }

        int distinct = set.size();

        HashMap<Integer, Integer> fre = new HashMap<>();
        int n = nums.length;
        int left = 0, res = 0;
        for (int right = 0; right < n; right++){
            fre.put(nums[right], fre.getOrDefault(nums[right], 0) + 1);
            while (fre.size() == distinct){
                res += n - right;

                fre.put(nums[left], fre.get(nums[left]) - 1);
                if (fre.get(nums[left]) == 0) fre.remove(nums[left]);
                left++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        CountCompleteSubarraysInAnArray_2799 c = new CountCompleteSubarraysInAnArray_2799();
        c.countCompleteSubarrays(new int[]{1,3,1,2,2});
    }
}
