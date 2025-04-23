package com.backtrack;

import com.dynamic_programming.PartitionEqualSumSubset_416;
import com.sun.security.auth.UnixNumericGroupPrincipal;

import java.util.ArrayList;
import java.util.Arrays;

public class PartitionToKEqualSumSubset_698 {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num: nums){
            sum += num;
        }

        if (sum % k != 0|| nums.length < k) return false;
        Arrays.sort(nums);
        int partition = sum / k;

        return canPartition(nums, new int[k], partition, nums.length - 1);
    }

    public boolean canPartition(int[] nums, int[] bucket, int partition, int used){
        if (used == -1){
            return true;
        }

        for (int i = 0; i < bucket.length; i++){
            if (bucket[i] + nums[used] <= partition){
                bucket[i] += nums[used];

                if (canPartition(nums, bucket, partition, used - 1)) return true;

                bucket[i] -= nums[used];
            }

            if (bucket[i] == 0) break;
        }

        return false;
    }


    public static void main(String[] args) {
        PartitionToKEqualSumSubset_698 p = new PartitionToKEqualSumSubset_698();
        p.canPartitionKSubsets(new int[]{4,3,2,3,5,2,1}, 4);
    }
}
