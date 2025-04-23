package com.backtrack;

import java.util.HashSet;

public class SplitaStringIntotheMaxNumberofUniqueSubstrings_1593 {
    int max = 0;
    public int maxUniqueSplit(String s) {
        backtracking(s, 0, new HashSet<>());
        return max;
    }

    public void backtracking(String s, int start, HashSet<String> tem) {
        if(start == s.length()){
            max = Math.max(max, tem.size());
            return;
        }

        for(int i = start + 1; i <= s.length(); i++){
            String t = s.substring(start, i);
            if(!tem.contains(t)){
                tem.add(t);
                backtracking(s, i, tem);
                tem.remove(t);
            }

        }
    }

    public static void main(String[] args) {
        SplitaStringIntotheMaxNumberofUniqueSubstrings_1593 s = new SplitaStringIntotheMaxNumberofUniqueSubstrings_1593();
        s.maxUniqueSplit("ababccc");
    }
}
