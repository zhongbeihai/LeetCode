package com.simulation;

public class ValidPalindromeII_680 {
    public boolean validPalindrome(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        boolean deleted = false;

        int left = 0, right = n - 1;
        while (left < right){
            char l = c[left], r = c[right];
            if (l != r){
                if (deleted) return  false;
                if (c[left + 1] == r){
                    left++;
                    deleted = true;
                    continue;
                } else if (c[right - 1] == l) {
                    right--;
                    deleted = true;
                    continue;
                }else {
                    return false;
                }
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidPalindromeII_680 v = new ValidPalindromeII_680();
        v.validPalindrome("abc");
    }
}
