package com.simulation;

public class ValidPalindrome_125 {
    public boolean isPalindrome(String s) {
        char[] ss = s.toCharArray();
        int left = 0, right = ss.length - 1;
        while (left < right){
            while(left < right && (!Character.isLetter(ss[left]) && !Character.isDigit(ss[left]))) left++;
            while (left < right && (!Character.isLetter(ss[right]) && !Character.isDigit(ss[right]))) right--;
            if (Character.toLowerCase(ss[left]) != Character.toLowerCase(ss[right])) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome_125 v = new ValidPalindrome_125();
        v.isPalindrome("race a car");
        // abcca
    }
}
