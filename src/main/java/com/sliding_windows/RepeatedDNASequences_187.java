package com.sliding_windows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNASequences_187 {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) return new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        int p = 0;
        StringBuilder sb = new StringBuilder();
        char[] ss = s.toCharArray();
        while (p < 10){
            sb.append(ss[p++]);
        }
        set.add(sb.toString());
        HashSet<String> res = new HashSet<>();
        for (int i = p; i < s.length(); i++){
            sb.append(ss[i]);
            sb.deleteCharAt(0);
            if (set.contains(sb.toString())) res.add(sb.toString());
            else set.add(sb.toString());
        }

        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        RepeatedDNASequences_187 r = new RepeatedDNASequences_187();
        r.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
    }
}
