package com.two_pointers;

import java.util.Arrays;

/**
 *Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 */
public class ReverseString_344 {
    public void reverseString(char[] s) {
        int h = 0, r = s.length - 1;
        while(h < r){
            char tem = s[h];
            s[h] = s[r];
            s[r] = tem;
            h++;
            r--;
        }

        System.out.println(Arrays.toString(s));
    }

    public static void main(String[] args) {
        ReverseString_344 reverseString_344 = new ReverseString_344();
        reverseString_344.reverseString(new char[]{'H', 'a','n','n','a','h'});
    }
}
