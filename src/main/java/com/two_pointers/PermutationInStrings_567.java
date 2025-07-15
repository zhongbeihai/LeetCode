package com.two_pointers;

public class PermutationInStrings_567 {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0;
        int[] window = new int[26];
        for(int i = 0; i < s1.length(); i++){
            window[s1.charAt(i) - 'a']++;
        }
        for(int right = 0; right < s2.length(); right++){
            int rightChar = s2.charAt(right) - 'a';
            window[rightChar]--;
            if(window[rightChar] == 0){
                if(right - left + 1 == s1.length()) return true;
            }
            while(window[rightChar] < 0){
                window[s2.charAt(left) - 'a']++;
                left++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PermutationInStrings_567 p = new PermutationInStrings_567();
        p.checkInclusion("ab", "eidbaooo");
    }
}
