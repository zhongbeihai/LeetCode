package com.simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class StringMatchInAnArray_1408 {
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();

        Arrays.sort(words, ((o1, o2) -> o1.length() - o2.length()));
        for(int i = 0; i < words.length; i++){
            for(int j = words.length - 1; j > i; j--){
                if(words[j].length() < words[i].length()) break;
                if(words[j].contains(words[i])) {
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        StringMatchInAnArray_1408 s = new StringMatchInAnArray_1408();
        s.stringMatching(new String[]{"leetcoder","leetcode"});
    }
}
