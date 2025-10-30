package com.simulation;

public class MissingElementInAnSortedArray_1060 {
    public int missingElement(int[] nums, int k) {
        int cur = nums[0], cnt= 0, i = 1;

        while (cnt < k && i < nums.length){
            cur++;
            if (cur < nums[i]){
                cnt++;
                continue;
            }
            i++;
        }

        while (cnt < k){
            cur++;
            cnt++;
        }

        return cur;
    }

    public static void main(String[] args) {
        MissingElementInAnSortedArray_1060 m = new MissingElementInAnSortedArray_1060();
        m.missingElement(new int[]{1,2,4}, 3);
    }
}
