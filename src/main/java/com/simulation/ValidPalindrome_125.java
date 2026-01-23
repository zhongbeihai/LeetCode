package com.simulation;

public class ValidPalindrome_125 {
    public boolean isPalindrome(String s) {
        int n = s.length();

        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            if (Character.isLetter(c)) sb.append(Character.toLowerCase(c));
            if (Character.isDigit(c)) sb.append(c);
        }

        char[] charArr = sb.toString().toCharArray();
        int left = 0, right = charArr.length - 1;
        while (left < right){
            if (charArr[left] != charArr[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome_125 v = new ValidPalindrome_125();
        v.isPalindrome("A man, a plan, a canal: Panama");
        // abcca
    }
}
