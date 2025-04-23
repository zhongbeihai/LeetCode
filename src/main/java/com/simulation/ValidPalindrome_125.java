package com.simulation;

public class ValidPalindrome_125 {
    public boolean isPalindrome(String s) {
        if (s.equals(" ")) return true;
        char[] ch = s.toCharArray();
        int n = ch.length;

        int i = 0, j = n - 1;
        while (i < j){
            char left = ch[i], right = ch[j];
            if (!Character.isAlphabetic(left) && !Character.isDigit(left)){
                i++;
                continue;
            }
            if (!Character.isAlphabetic(right) && !Character.isDigit(right)){
                j--;
                continue;
            }
            if (Character.isUpperCase(left)) left = Character.toLowerCase(left);
            if (Character.isUpperCase(right)) right = Character.toLowerCase(right);
            if (left != right) return false;
            else {
                i++;
                j--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome_125 v = new ValidPalindrome_125();
        v.isPalindrome("0P");
        // abcca
    }
}
