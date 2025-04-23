package com.simulation;

public class ShortestPalindrome_214 {
    public String shortestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        String rs = sb.reverse().toString();
        int n = rs.length();
        StringBuilder ss = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(!s.substring(0,n - i).equals(rs.substring(i, n))){
                continue;
            }

            ss.append(rs.substring(0, i)).append(s);
            return ss.toString();
        }
        return ss.append(s).reverse().append(s).toString();
    }

    public static void main(String[] args) {
        ShortestPalindrome_214 s = new ShortestPalindrome_214();
        s.shortestPalindrome("abbacd");
    }
}
