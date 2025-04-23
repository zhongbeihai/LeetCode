package com.sliding_windows;

import java.util.HashMap;
import java.util.HashSet;

public class FindKLengthSubstringWithNoRepeatedCharacters_1100 {
    public int numKLenSubstrNoRepeats(String s, int k) {
        int left = 0, res = 0;
        HashSet<Character> fre = new HashSet<>();

        for (int right = 0; right < s.length(); right++){
            char rightChar = s.charAt(right);

            while (left <= right && fre.contains(rightChar)){
                fre.remove(s.charAt(left));
                left++;
            }
            fre.add(rightChar);


            while (right - left == k - 1){
                res++;
                fre.remove(s.charAt(left));
                left++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        FindKLengthSubstringWithNoRepeatedCharacters_1100 f= new FindKLengthSubstringWithNoRepeatedCharacters_1100();
        f.numKLenSubstrNoRepeats("jcgbcgaheedfhlnagojn", 5);
    }
}
