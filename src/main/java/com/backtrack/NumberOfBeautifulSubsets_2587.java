package com.backtrack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class NumberOfBeautifulSubsets_2587 {
    private int countBeautiful = 0;
    private HashMap<Integer, Integer> map = new HashMap<>();
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        backTracking(nums, 0, k);

        return countBeautiful;
    }

    public void backTracking(int[] nums, int index, int k){
        if(map.size() != 0){
            countBeautiful++;
        }

        for(int i = index; i < nums.length; i++){
            if(map.containsKey(nums[i] - k) || map.containsKey(nums[i] + k)) continue;
            map.put(nums[i], map.getOrDefault(nums[i], 0 ) + 1);

            backTracking(nums, i + 1, k);

            map.put(nums[i], map.get(nums[i]) - 1);
            if(map.get(nums[i]) == 0) map.remove(nums[i]);

        }
    }

}
