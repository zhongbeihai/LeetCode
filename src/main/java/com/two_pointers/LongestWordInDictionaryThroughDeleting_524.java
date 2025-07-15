package com.two_pointers;

import java.util.ArrayList;
import java.util.List;

public class LongestWordInDictionaryThroughDeleting_524 {
    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (String dic: dictionary){
            if (dic.length() < res.length() ||  (dic.length() == res.length() && dic.compareTo(res) < 0)) continue;
            int sp = 0, dp = 0;
            while (sp < s.length()){
                if (s.charAt(sp) == dic.charAt(dp)){
                    dp++;
                }
                sp++;
                if (dp == dic.length()) {
                    res = dic;
                    break;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> l = new ArrayList<>();
        l.add("ale");
        l.add(("apple"));
        LongestWordInDictionaryThroughDeleting_524 l0 = new LongestWordInDictionaryThroughDeleting_524();
        l0.findLongestWord(s, l);
    }
}
