package com.simulation;

public class MakeArrayEleEqualToZero_3354 {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n], suffix = new int[n];
        prefix[0] = nums[0]; suffix[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++){
            prefix[i] = prefix[i - 1] + nums[i];
        }
        for (int i = n - 2; i >= 0; i--){
            suffix[i] = suffix[i + 1] + nums[i];
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0 && prefix[i] == suffix[i]) res += 2;
            else if (nums[i] == 0 && Math.abs(prefix[i] - suffix[i]) == 1)  {
                res += 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        MakeArrayEleEqualToZero_3354 m = new MakeArrayEleEqualToZero_3354();
        m.countValidSelections(new int[]{1,0,2,0,3});
    }
}
