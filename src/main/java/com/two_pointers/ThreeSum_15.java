package com.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            List<Integer> tem = new ArrayList<>();
            tem.add(nums[i]);
            int start = 0, end = nums.length - 1;
            while (start < end){
                if(nums[start] + nums[end] + nums[i] == 0){
                    if(start != i && end != i){
                        tem.add(nums[start]);
                        tem.add(nums[end]);
                        res.add(new ArrayList<>(tem));
                        start++;
                        end--;
                        while (start < end && nums[start] == nums[start - 1]){
                            start++;
                        }
                        while (start < end && nums[end] == nums[end + 1]){
                            end--;
                        }
                    }

                } else if (nums[start] + nums[end] + nums[i] > 0) {
                    end--;
                } else if (nums[start] + nums[end] + nums[i] < 0) {
                    start++;
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
