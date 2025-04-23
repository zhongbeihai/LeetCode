package com.simulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TheKthFactorOfN_1492 {
    public int kthFactor(int n, int k) {
        List<Integer> h = new ArrayList<>();
        List<Integer> r = new ArrayList<>();

        for (int i = 1; i * i <= n; i++){
            if (n % i == 0){
                h.add(i);
                if (n / i != i ) r.add(n / i);
            }
        }

        Collections.reverse(r);

        if (k > h.size() + r.size()) return -1;
        if (k > h.size()){
            return r.get(k - h.size() - 1);
        }else {
            return h.get(k - 1);
        }
    }

    public static void main(String[] args) {
        TheKthFactorOfN_1492 t = new TheKthFactorOfN_1492();
        t.kthFactor(4, 4);
    }
}
