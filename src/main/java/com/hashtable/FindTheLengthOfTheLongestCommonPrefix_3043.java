package com.hashtable;

import java.util.Arrays;
import java.util.HashSet;

public class FindTheLengthOfTheLongestCommonPrefix_3043 {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<String> possiblePrefix = new HashSet<>();
        for(Integer i : arr1){
            String p = String.valueOf(i);
            for(int j = 1; j <= p.length(); j++){
                String sub = p.substring(0, j);
                possiblePrefix.add(sub);
            }
        }
        int max = 0;
        for (Integer i : arr2){
            String p = String.valueOf(i);
            StringBuilder sb = new StringBuilder();
            for(char c : p.toCharArray()){
                sb.append(c);
                if(possiblePrefix.contains(sb.toString())){
                    max = Math.max(max, sb.length());
                }else {
                    break;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        FindTheLengthOfTheLongestCommonPrefix_3043 f = new FindTheLengthOfTheLongestCommonPrefix_3043();
        f.longestCommonPrefix(new int[]{13,27,45}, new int[]{27});
    }
}
