package com.greedy;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromeByConcatenatiningTwoLetterWords_2131 {
    public int longestPalindrome(String[] words) {
        StringBuilder fastHalf = new StringBuilder();
        StringBuilder lastHalf = new StringBuilder();
        StringBuilder middle = new StringBuilder();

        HashMap<String, Integer> palindrome = new HashMap<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String word: words){
            String reverse = new StringBuffer(word).reverse().toString();
            if (map.containsKey(reverse)){
                fastHalf.append(word);
                lastHalf.append(reverse);
                map.put(reverse, map.get(reverse) - 1);
                if (map.get(reverse) == 0) map.remove(reverse);
            }else {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry: map.entrySet()){
            if (isPalindrome(entry.getKey())){
                for (int i = 0; i < entry.getValue() / 2; i++){
                    fastHalf.append(entry.getKey());
                    lastHalf.append(entry.getKey());
                }

                if (entry.getValue() % 2 == 1 && middle.length() == 0) middle.append(entry.getKey());
            }
        }

        if (fastHalf.length() == 0 && middle.length() == 0) return 0;
        return fastHalf.length() * 2 + middle.length();
    }

    public boolean isPalindrome(String str){
        char[] chars = str.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left <= right){
            if (chars[left] == chars[right]){
                left++;
                right--;
            }else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        LongestPalindromeByConcatenatiningTwoLetterWords_2131 l = new LongestPalindromeByConcatenatiningTwoLetterWords_2131();
        l.longestPalindrome(new String[]{"qo","fo","fq","qf","fo","ff","qq","qf","of","of","oo","of","of","qf","qf","of"});
    }
}
