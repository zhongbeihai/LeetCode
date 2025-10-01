package com.backtrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {
    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(n, 0, 0, "");
        return res;
    }

    public void backtrack(int n, int lp, int rp, String tem){
        // stop condition
        if (tem.length() == n * 2){
            res.add(tem);
            return;
        }

        if (lp < n){
            backtrack(n, lp + 1, rp, tem + "(");
        }

        if (rp < lp){
            backtrack(n, lp, rp + 1, tem + ")");
        }
    }

    public static void main(String[] args) {
        GenerateParentheses_22 g = new GenerateParentheses_22();
        g.generateParenthesis(3);
    }
}
     