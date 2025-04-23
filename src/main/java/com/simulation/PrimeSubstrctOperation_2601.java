package com.simulation;

import java.util.stream.IntStream;

public class PrimeSubstrctOperation_2601 {
    public boolean primeSubOperation(int[] nums) {
        nums[0] -= largestPrimeLessThan(nums[0]);
        for(int i = 1; i < nums.length; i++){
            if(i == nums.length - 1 && nums[i] > nums[i - 1]) continue;
            int prime = largestPrimeLessThan(nums[i]);
            while (nums[i] - prime <= nums[i - 1]){
                prime = largestPrimeLessThan(prime);
            }
            if (prime == -1 ) return false;
            nums[i] -= prime;
        }

        return true;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false; // 0 和 1 不是素数
        return IntStream.rangeClosed(2, (int) Math.sqrt(n))
                .allMatch(i -> n % i != 0);
    }

    public static int largestPrimeLessThan(int target) {
        for (int i = target - 1; i >= 2; i--) { // 从 target - 1 开始向下搜索
            if (isPrime(i)) {
                return i; // 找到第一个素数时返回
            }
        }
        return -1; // 如果没有找到，返回 -1
    }

    public static void main(String[] args) {
        PrimeSubstrctOperation_2601 p =new PrimeSubstrctOperation_2601();
        p.primeSubOperation(new int[]{998,2});
    }
}
