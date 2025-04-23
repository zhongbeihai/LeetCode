package com.simulation;

import java.util.HashSet;

public class FindTheCountOfGoodIntegers_3272 {
    public long countGoodIntegers(int n, int k) {
        long count = 0;
        HashSet<String> set = new HashSet<>();
        for (int i = (int) Math.pow(10, n - 1);  i < (int) Math.pow(10, n); i++){
            String key = buildKey(i);
            if (set.contains(key)) continue;
            if (isPalindrome(i)){
                int digits = countDigits(i);
                count += countUniquePermutations(digits) + 1;
                set.add(key);
            }
        }

        return count;
    }


    public  int countDigits(int num) {
        if (num == 0) return 1;
        return (int) Math.floor(Math.log10(Math.abs(num))) + 1;
    }

    public boolean isPalindrome(int num){
        String numm = String.valueOf(num);

        for (int i = 0, j = numm.length() - 1; i != j; i++, j--){
            if (numm.charAt(i) != numm.charAt(j)) return false;
        }

        return true;
    }

    public  int countUniquePermutations(int num) {
        // 1. 统计每个数字的出现次数
        int[] counts = new int[10];
        int totalDigits = 0;
        while (num > 0) {
            counts[num % 10]++;
            num /= 10;
            totalDigits++;
        }

        // 2. 计算总的排列数：totalDigits!
        long totalPermutations = factorial(totalDigits);

        // 3. 除以每个数字重复的阶乘：n! / (count1! * count2! * ...)
        for (int count : counts) {
            if (count > 1) {
                totalPermutations /= factorial(count);
            }
        }

        // 4. 去除前导零的非法情况
        if (counts[0] == 0) {
            return (int) totalPermutations;
        } else {
            // 前导位不能是 0，需要特殊处理：
            long validPermutations = 0;
            // 假设第一位选择不是 0 的数字
            for (int firstDigit = 1; firstDigit <= 9; firstDigit++) {
                if (counts[firstDigit] == 0) continue;

                counts[firstDigit]--;
                long permutationsForThisFirstDigit = factorial(totalDigits - 1);

                // 除以其余数字的重复数量阶乘
                for (int count : counts) {
                    if (count > 1) {
                        permutationsForThisFirstDigit /= factorial(count);
                    }
                }

                validPermutations += permutationsForThisFirstDigit;
                counts[firstDigit]++; // 回溯
            }

            return (int) validPermutations;
        }
    }

    private static long factorial(int n) {
        long result = 1L;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    private  String buildKey(int num) {
        int[] counts = new int[10];
        while (num > 0) {
            counts[num % 10]++;
            num /= 10;
        }

        StringBuilder key = new StringBuilder();
        for (int count : counts) {
            key.append(count).append('#'); // 用特殊字符分隔避免混淆
        }
        return key.toString();
    }

    public static void main(String[] args) {
        FindTheCountOfGoodIntegers_3272 f = new FindTheCountOfGoodIntegers_3272();
        f.countGoodIntegers(3, 5);
    }
}
