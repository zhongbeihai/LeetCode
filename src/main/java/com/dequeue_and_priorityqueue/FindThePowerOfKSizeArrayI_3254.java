package com.dequeue_and_priorityqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindThePowerOfKSizeArrayI_3254 {
    public int[] resultsArray(int[] nums, int k) {
        int left = 0, right = 0;
        List<Integer> ans = new ArrayList<>();
        Collections.fill(ans, -1);
        int ascendingLen = 0;
        while (right - left  + 1< k){
            right++;
            if(nums[right] == nums[right - 1] + 1) ascendingLen++;
            else  ascendingLen = 0;
        }
        while (right < nums.length){
            if(ascendingLen >= k - 1){
                ans.add(nums[right]);
            }else {
                ans.add(-1);
            }
            right++;
            left++;
            if(right < nums.length && nums[right] == nums[right - 1] + 1) ascendingLen++;
            else  ascendingLen = 0;
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        FindThePowerOfKSizeArrayI_3254 f = new FindThePowerOfKSizeArrayI_3254();
        f.resultsArray(new int[]{1,2,3,4,3,2,5}, 3);
    }
}
