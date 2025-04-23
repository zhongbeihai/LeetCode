package com.doublepointers;

public class PartitionArrayAccordingToGivenPivot_2161 {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int p1 = 0, p2 = n - 1;
        int[] res= new int[n];
        for (int i = 0, j = n - 1; i < n; i++, j--){
            if (nums[i] < pivot){
                res[p1] = nums[i];
                p1++;
            }

            if (nums[j] > pivot){
                res[p2] = nums[j];
                p2--;
            }
        }

        while (p1 < p2){
            res[p1] = pivot;
            p1++;
        }

        return res;
    }
}
