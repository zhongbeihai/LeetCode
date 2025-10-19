package com.simulation;

import java.util.Arrays;
import java.util.HashSet;

public class StrobogrammaticNumber_246 {
    public boolean isStrobogrammatic(String num) {
        HashSet<Character> single = new HashSet<>(Arrays.asList('0', '1','8'));
        HashSet<Character> set = new HashSet<>(Arrays.asList('0', '1', '6','8','9'));
        char[] nums = num.toCharArray();
        if (nums.length == 1) return single.contains(nums[0]);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (!set.contains(nums[left]) || !set.contains(nums[right])) return false;
            if (!single.contains(nums[left]) && nums[left] == nums[right]) return false;
            if (nums[left] != nums[right] && !(nums[left] == '6' && nums[right] == '9') && !(nums[left] == '9' && nums[right] == '6')) return false;
            left++; right--;
        }

        return true;
    }

    public static void main(String[] args) {
        StrobogrammaticNumber_246 s = new StrobogrammaticNumber_246();
        s.isStrobogrammatic("10");
    }
}
