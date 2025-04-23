package com.dynamic_programming;

public class DeleteOperationForTwoStrings_583 {
    public int minDistance(String word1, String word2) {
        int m = word1.length() - 1, n = word2.length() - 1;
        return dp(word1, m, word2, n);
    }

    public int dp(String word1, int i, String word2, int j){
        if(i == -1) return j + 1;
        if(j == -1) return i + 1;

        if(word1.charAt(i) == word2.charAt(j)){
            // do nothing
            return dp(word1, i - 1, word2, j - 1);
        }

        return min(
                // delete
                dp(word1, i - 1, word2, j) + 1,
                // add
                dp(word1, i, word2, j - 1) + 1,
                //replace
                dp(word1, i - 1, word2, j - 1) + 1
        );
    }

    public int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }
}
