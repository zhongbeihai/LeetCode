package com.prefixsum;

import java.util.HashMap;

public class ContiguousArray_525 {
    public int findMaxLength(int[] nums) {
        //
        HashMap<Integer, Integer> map = new HashMap<>();
        int ones = 0, zeros = 0, diff = 0;
        int maxLen = 0;
        map.put(0 , 0);
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0) zeros++;
            else ones++;
            diff = ones - zeros;
            if (map.containsKey(diff)){
                maxLen = Math.max(maxLen, i - map.get(diff));
            }else {
                map.put(diff, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        ContiguousArray_525 c= new ContiguousArray_525();
        c.findMaxLength(new int[]{0,1,1,1,1,1,0,0,0});
    }
}
