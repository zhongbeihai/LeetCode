package com.simulation;

public class MaximumNumberOfOperationsToMoveOnesToTheEnd_3228 {
    public int maxOperations(String s) {
        int ones = 0;

        int res = 0;
        char prev = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') ones++;
            else if (s.charAt(i) == '0' && prev == '1'){
                res += ones;
            }
            prev = s.charAt(i);
        }

        return res;
    }

    public static void main(String[] args) {
        MaximumNumberOfOperationsToMoveOnesToTheEnd_3228 m = new MaximumNumberOfOperationsToMoveOnesToTheEnd_3228();
        m.maxOperations("1001101");
    }
}
