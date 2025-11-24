package com.simulation;

public class MaximumNumberOfOperationsToMoveOnesToTheEnd_3228 {
    public int maxOperations(String s) {
        int ones = 0;

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 1) ones++;
            else {
                res += ones;
            }
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
