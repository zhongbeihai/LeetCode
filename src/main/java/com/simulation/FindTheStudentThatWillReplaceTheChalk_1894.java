package com.simulation;

import java.util.Arrays;

public class FindTheStudentThatWillReplaceTheChalk_1894 {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long[] prefixSum = new long[n];
        prefixSum[0] = chalk[0];
        for (int i = 1; i < n; i++){
            prefixSum[i] = prefixSum[i - 1] + chalk[i];
        }

        long rest = k % prefixSum[n - 1];
        int idx = Arrays.binarySearch(prefixSum, rest);

        return idx >= 0 ? idx + 1: -idx - 1;
    }

    public static void main(String[] args) {
        FindTheStudentThatWillReplaceTheChalk_1894 f = new FindTheStudentThatWillReplaceTheChalk_1894();
        // f.chalkReplacer(new int[]{3,4,1,2}, 25);
        f.chalkReplacer(new int[]{1,1,1}, 2);
    }
}
