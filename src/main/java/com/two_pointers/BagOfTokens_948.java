package com.two_pointers;

import java.util.Arrays;

public class BagOfTokens_948 {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int left = 0, right = tokens.length - 1;

        int scores = 0, maxScores = 0;
        while (left <= right){
            if (power >= tokens[left]){
                scores++;
                maxScores = Math.max(maxScores, scores);
                power -= tokens[left];
                left++;
            } else if (scores > 0 && power < tokens[left]) {
                scores--;
                power += tokens[right];
                right--;
            }else {
                break;
            }
        }

        return maxScores;
    }

    public static void main(String[] args) {
        BagOfTokens_948 b = new BagOfTokens_948();
        b.bagOfTokensScore(new int[]{200, 100}, 150);
    }
}
