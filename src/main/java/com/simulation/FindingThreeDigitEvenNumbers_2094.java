package com.simulation;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindingThreeDigitEvenNumbers_2094 {
    public int[] findEvenNumbers(int[] digits) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(digits);
        int[] map = new int[10];
        for (int d: digits) map[d]++;

        for (int i = 1; i <= 9; i++){
            if (map[i] == 0) continue;
            map[i]--;
            for (int j = 0; j <= 9; j++){
                if (map[j] == 0) continue;
                map[j]--;
                for (int k = 0; k < 9; k += 2){
                    if (map[k] == 0) continue;
                    list.add(i*100 + j * 10 + k);
                }
                map[j]++;
            }
            map[i]++;
        }

        int[] res = list.stream().mapToInt(Integer::intValue).toArray();
        return res;
    }
}
