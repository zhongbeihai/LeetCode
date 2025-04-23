package com.backtrack;

import java.util.ArrayList;
import java.util.List;

public class WordBreak_139_Backtrack {

    private boolean res = false;
    public boolean wordBreak(String s, List<String> wordDict) {
        backtracing(s, wordDict, 0, new ArrayList<>());

        return res;
    }

    public void backtracing(String s, List<String> wordDict, int start, List<String> tem){
        StringBuilder sb = new StringBuilder();
        for(String i: tem) sb.append(i);
        if(sb.toString().equals(s)){
            res = true;
            return;
        }
        if (sb.toString().length() >= s.length()) return;

        for(int i = start; i < wordDict.size(); i++){
            tem.add(wordDict.get(i));

            backtracing(s, wordDict, 0, tem);

            tem.remove(tem.size() - 1);
        }
    }

    public static void main(String[] args) {
        WordBreak_139_Backtrack w = new WordBreak_139_Backtrack();
        ArrayList<String> a = new ArrayList<>();
        a.add("leet");
        a.add("code");
        w.wordBreak("leetcodeleet", a);
    }
}
