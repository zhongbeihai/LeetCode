package com.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumMovesToBalanceCircularArray_3776 {
    public long minMoves(int[] balance) {
        int n = balance.length;
        long sum = 0L;
        int negative = 0, negativeIdx = -1;
        boolean hasNegative = false;
        for (int i = 0; i < n; i++){
            sum += balance[i];
            if (balance[i] < 0) {
                hasNegative = true;
                negative = balance[i];
                negativeIdx = i;
            }
        }
        if (!hasNegative) return 0;
        if (sum < 0) return -1;
        negative = -negative;

        int left = (negativeIdx - 1 + n) % n, right = (negativeIdx + 1) % n;
        int dis = 1;
        long res = 0L;
        while (negative > 0 && dis <= n){
            if (left == right) {
                int avail = balance[left];
                if (avail > 0) {
                    int take = Math.min(negative, avail);
                    res += (long) take * dis;
                    negative -= take;
                }
                break;
            }

            // take from left
            int availL = balance[left];
            if (availL > 0 && negative > 0) {
                int take = Math.min(negative, availL);
                res += (long) take * dis;
                negative -= take;
            }

            // take from right
            int availR = balance[right];
            if (availR > 0 && negative > 0) {
                int take = Math.min(negative, availR);
                res += (long) take * dis;
                negative -= take;
            }

            left = (left - 1 + n) % n;
            right = (right + 1) % n;
            dis++;
        }

        return res;
    }

    public static void main(String[] args) {
        MinimumMovesToBalanceCircularArray_3776 m = new MinimumMovesToBalanceCircularArray_3776();
        m.minMoves(new int[]{5,1,-4});
    }
}
