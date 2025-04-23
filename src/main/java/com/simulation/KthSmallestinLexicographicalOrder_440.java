package com.simulation;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestinLexicographicalOrder_440 {
    ArrayList<Integer> res = new ArrayList<Integer>();
    public int findKthNumber(int n, int k) {
        lexicalOrder(n);
        return res.get(k - 1);
    }

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
        KthSmallestinLexicographicalOrder_440 k = new KthSmallestinLexicographicalOrder_440();
        k.findKthNumber(13,2);
    }
}
