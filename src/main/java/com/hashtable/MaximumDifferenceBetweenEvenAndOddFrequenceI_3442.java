package com.hashtable;

public class MaximumDifferenceBetweenEvenAndOddFrequenceI_3442 {
    public int maxDifference(String s) {
        int[] fre = new int[26];
        for(char c: s.toCharArray()){
            fre[c - 'a']++;
        }

        int maxEven = 0, maxOdd = 0, minEven = Integer.MAX_VALUE;
        for (int i: fre){
            if (i % 2 == 0) {
                maxEven = Math.max(i, maxEven);
                if(i != 0) minEven = Math.min(i, minEven);
            }
            else maxOdd = Math.max(i, maxOdd);
        }

        return Math.max(maxOdd - minEven, maxOdd - maxEven);
    }
}
