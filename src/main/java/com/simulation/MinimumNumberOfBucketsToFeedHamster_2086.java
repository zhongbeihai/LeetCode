package com.simulation;

public class MinimumNumberOfBucketsToFeedHamster_2086 {
    public int minimumBuckets(String hamsters) {
        char[] charArray = hamsters.toCharArray();

        int res = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != 'H') continue;
            if (i > 0 && charArray[i - 1] == 'B') continue;

            if (i + 1 < charArray.length && charArray[i + 1] == '.'){
                charArray[i + 1] = 'B';
            } else if (i > 0 && charArray[i - 1] == '.') {
                charArray[i - 1] = 'B';
            }else {
                return -1;
            }
            res++;
        }

        return res;
    }
}
