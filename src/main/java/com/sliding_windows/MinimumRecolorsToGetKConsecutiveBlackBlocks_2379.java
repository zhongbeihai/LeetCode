package com.sliding_windows;

public class MinimumRecolorsToGetKConsecutiveBlackBlocks_2379 {
    public int minimumRecolors(String blocks, int k) {
        int res = Integer.MAX_VALUE;
        int left = 0; // maintain the left boundary of sliding window
        char[] blocksChar = blocks.toCharArray();
        int count = 0;
        for (int right = 0; right < k; right++){
            if (blocksChar[right] == 'W') count++;
        }
        for (int right = k; right < blocksChar.length; right++){
            // If window size < k, move to right
            if (blocksChar[right] == 'W') count++;

            // If window size > k, move left boundary
            if (blocksChar[left] == 'W') count--;
            left++;

            res = Math.min(res, count);
        }

        return res;
    }
}
