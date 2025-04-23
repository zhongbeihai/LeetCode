package com.backtrack;

import java.util.ArrayList;
import java.util.List;

public class TheKthOfLexicographicalStringsOfAllHappyStringOfLengthN_1415 {
    private List<String> list = new ArrayList<>();
    private char[] dics = new char[]{'a','b','c'};
    public String getHappyString(int n, int k) {
        backtrack(n, new StringBuilder());

        if (k > list.size()) return "";
        return list.get(k - 1);
    }

    public void backtrack(int n, StringBuilder sb){
        // stop condition
        if (sb.length() == n){
            list.add(sb.toString());
            return;
        }


            for (int j = 0; j < 3; j++){
                // constrained condition
                if (sb.length() > 0 && dics[j] == sb.charAt(sb.length() - 1))continue;
                sb.append(dics[j]);

                backtrack(n, sb);

                sb.deleteCharAt(sb.length() - 1);
            }

    }

    public static void main(String[] args) {
        TheKthOfLexicographicalStringsOfAllHappyStringOfLengthN_1415 t = new TheKthOfLexicographicalStringsOfAllHappyStringOfLengthN_1415();
        t.getHappyString(1, 3);
    }
}
