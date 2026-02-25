package lc100hot;

import java.util.HashSet;

public class A {
    public boolean hasSubarrayKMod6e6(int[] nums, int k){
        int n = nums.length;
        long MOD = 6_000_009L;
        long[] prefixSum = new long[n + 1];
        for (int i = 1; i < prefixSum.length; i++){
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        HashSet<Long> set = new HashSet<>();
        set.add(0L);
        for (int i = 1; i < n + 1; i++){
            long cur = prefixSum[i] % MOD;
            long target = (cur - k) % MOD;
            if (target < 0) target += MOD;

            if (set.contains(target)) return true;
            set.add(prefixSum[i] % MOD);
        }

        return false;
    }
}
