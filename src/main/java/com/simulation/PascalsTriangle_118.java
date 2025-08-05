package com.simulation;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tem = new ArrayList<>();
        tem.add(1);
        res.add(new ArrayList<>(tem));

        if (numRows == 1) return res;
        tem.add(1);
        res.add(new ArrayList<>(tem));
        if (numRows == 2) return res;

        for (int i = 2; i < numRows; i++){
            List<Integer> t = new ArrayList<>();
            t.add(1);
            List<Integer> last = res.get(i - 1);
            for (int j = 1; j < i; j++){
                t.add(last.get(j) + last.get(j - 1));
            }
            t.add(1);
            res.add(t);
        }

        return res;
    }

    public static void main(String[] args) {
        PascalsTriangle_118 p = new PascalsTriangle_118();
        p.generate(5);
    }
}
