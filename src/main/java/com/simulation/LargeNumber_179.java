package com.simulation;

import java.util.Arrays;

public class LargeNumber_179 {
    public String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        for(int i = 0; i< nums.length; i++){
            s[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(s, (a, b) -> -(a+b).compareTo(b+a));

        if(s[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length; i++){
            sb.append(s[i]);
        }

        return sb.toString();
    }


}
