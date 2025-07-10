package com.simulation;

import javafx.beans.binding.StringBinding;

public class FindTheKCharacterInTheStringGameII_3307 {
    public char kthCharacter(long k, int[] operations) {
        int shiftTimes = 0;
        long len = 1;

        for (int i = 0; i < operations.length; i++){
            len *= 2;

            if (len >= k){
                for (int j = i; j >= 0; j--){
                    long half = len / 2;

                    if (k > half){
                        k = k - half; // prev position;
                        if (operations[j] == 1) shiftTimes++;
                    }

                    len /= 2;
                }


                break;
            }
        }

        return (char) ((shiftTimes % 26) + 'a');
    }
}
