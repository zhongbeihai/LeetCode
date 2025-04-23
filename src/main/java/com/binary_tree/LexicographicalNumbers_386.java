package com.binary_tree;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers_386 {
    List<Integer> res =  new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {
        for (int i = 1; i <= 9; i++) {
            help(i, n);
        }
        return res;
    }

    public void help(int start, int max){
        if(start > max) return;
        res.add(start);
        for(int i = 0; i < 10; i++){
            help(start * 10 + i, max);
        }
    }

    public static void main(String[] args) {
        LexicographicalNumbers_386 l = new LexicographicalNumbers_386();
        l.lexicalOrder(13);
    }
}
