package com.simulation;

public class CircularSentence_2490 {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        boolean res = true;
        for(int i = 0; i < words.length - 1; i++){
            if(words[i].charAt(words[i].length() - 1) != words[i + 1].charAt(0)) return false;
        }
        if(words[words.length - 1].charAt(words[words.length - 1].length() - 1) != words[0].charAt(0)) return false;
        return res;
    }

    public static void main(String[] args) {
        CircularSentence_2490 c = new CircularSentence_2490();
        c.isCircularSentence("leetcode exercises sound delightful");
    }
}
