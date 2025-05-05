package com.hashtable;

import java.util.Arrays;
import java.util.HashMap;

public class TheNumberOfEquivalentDominoPairs_1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<Integer, Integer> fre = new HashMap<>();
        int res = 0;
        for (int[] domino: dominoes){
            int a = domino[0], b = domino[1];
            if (a < b) {
                int hash = Arrays.hashCode(domino);
                fre.put(hash, fre.getOrDefault(hash, 0) + 1);
                res += fre.get(hash) - 1;
            }
            else {
                int[] tem = new int[]{b, a};
                int hash = Arrays.hashCode(tem);
                fre.put(hash, fre.getOrDefault(hash, 0)+ 1);
                res += fre.get(hash) - 1;
            }

        }

        return res;
    }

    public int factorial(int number) {
        if (number <= 1)
            return 1;
        else
            return number + factorial(number - 1);
    }

    public static void main(String[] args) {
        TheNumberOfEquivalentDominoPairs_1128 t = new TheNumberOfEquivalentDominoPairs_1128();
        t.numEquivDominoPairs(new int[][]{{1,2},{1,2},{2,1}});
    }
}
