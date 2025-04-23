package com.prefixsum;

import java.util.ArrayList;

public class MinimumNumberOfOperationsToMoveAllBallsToEachBox_1769 {
    public int[] minOperations(String boxes) {
        int[] prefix = new int[boxes.length() + 1];
        int count = 0;
        for(int i = 1; i <= boxes.length(); i++){
            prefix[i] = prefix[i - 1] + count;
            count = boxes.charAt(i) == '1' ? count + 1 : count;
        }

        int[] suffix = new int[boxes.length() + 1];
        for(int i = boxes.length() - 2; i >= 0; i--){
            suffix[i] = suffix[i + 1] + count;
            count += (boxes.charAt(i) == '1' ? 1 : 0);
        }

        int[] res = new int[boxes.length()];
        for (int i = 0; i < boxes.length(); i++) {
            res[i] = prefix[i] + suffix[i];
        }

        return res;
    }
}
