package com.search;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers_386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= 9; i++){
            if (i <= n){
                res.addAll(helper(i, n));
            }
        }

        return res;
    }

    public List<Integer> helper(int start, int n){
        List<Integer> r = new ArrayList<>();
        if (start > n) return r;

        r.add(start);
        for (int i = 0; i <= 9; i++){
            int newStart = start * 10 + i;
            if (newStart > n) break;
            r.addAll(helper(newStart, n));
        }

        return r;
    }

    public static void main(String[] args) {
        LexicographicalNumbers_386 l = new LexicographicalNumbers_386();
        l.lexicalOrder(13);
    }
}
