package com.dequeue_and_priorityqueue;

import java.util.Arrays;

public class TakeKOfEachCharacterFromLeftAndRight_2516 {
    public int takeCharacters(String s, int k) {
        int[] count = new int[3];
        char[] ss = s.toCharArray();
        for(char c: ss){
            count[c-'a']++;
        }

        if(Arrays.stream(count).anyMatch(e -> e < k) ) return -1;

        int l = 0, r, max = 0;
        for(r = 0; r < s.length(); r++){
            count[ss[r] - 'a']--;
            while (notValidBreak(count, k)){
                count[ss[l] - 'a']++;
                l++;
            }
            max = Math.max(max, r - l + 1);
        }

        return s.length() - max;
    }

    boolean notValidBreak(int[] count, int k){
        return Arrays.stream(count).anyMatch(e -> e < k);
    }

    public static void main(String[] args) {
        TakeKOfEachCharacterFromLeftAndRight_2516 t = new TakeKOfEachCharacterFromLeftAndRight_2516();
        t.takeCharacters("aabaaaacaabc", 2);
    }
}
