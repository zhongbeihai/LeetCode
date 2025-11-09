package com.systemdesign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomPickIndex {
    private HashMap<Integer, List<Integer>> map = new HashMap<>();
    public RandomPickIndex(int[] nums){
        for (int i = 0; i < nums.length; i++){
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        if (list == null) return -1;

        Random random = new Random();
        int r = random.nextInt(5 * list.size());

        return list.get(r % list.size());
    }
}
