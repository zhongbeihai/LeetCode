package com.doublepointers;

import java.util.*;
import java.util.stream.Collectors;

public class SumClosestII_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        for(int j = 0; j < nums.length; j++){
            if(nums[j] > 0 && nums[j] > target) break;
            if(j > 0 && nums[j] == nums[j - 1]) continue;
            int n1 = nums[j];
            for(int i = j + 1; i < nums.length; i++){
                int n2 = nums[i];
                if(nums[i] > 0 && nums[i] + nums[j] > target) break;
                if(i > j + 1 && n2 == nums[i - 1]) continue;
                int left = i + 1, right = nums.length - 1;
                while (left < right){
                    int n3 = nums[left], n4 = nums[right];
                    int curSum = n1 + n2 + n3 + n4;
                    if(curSum == target){
                        res.add(Arrays.asList(n1,n2,n3,n4));
                        while (left < right && n3 == nums[left]) left++;
                        while (left < right && n4 == nums[right]) right--;
                    }else if(curSum > target){
                        right--;
                    }else {
                        left++;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        SumClosestII_18 s= new SumClosestII_18();
        s.fourSum(new int[]{-3,-2,-1,0,0,1,2,3}, 0);
    }
}
