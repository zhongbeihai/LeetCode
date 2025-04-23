package com.dynamic_programming;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MaximumNumberofCoinsYouCanGet_1561 {
    public int maxCoins(int[] piles) {
        Integer[] aInteger = Arrays.stream(piles).boxed().toArray(Integer[]::new);
        Arrays.sort(aInteger, Collections.reverseOrder());
        int cnt = 0;
        int to = aInteger.length / 3 * 2;
        Integer[] bAndA = Arrays.copyOfRange(aInteger, 0, to);
        for(int i = 1; i < bAndA.length; i += 2){
            cnt += bAndA[i];
        }
        return cnt;
    }

    public static void main(String[] args) {
        MaximumNumberofCoinsYouCanGet_1561 m = new MaximumNumberofCoinsYouCanGet_1561();
        m.maxCoins(new int[]{2,4,1,2,7,8});
    }
}
