package com.backtrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {
    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(n, 0, 0, "");
        return res;
    }

    public void backtrack(int n, int numOfLeftP, int numOfRightP, String sb){
        if (sb.length() == n * 2) {
            res.add(sb);
            return;
        }

        if (numOfLeftP < n){
            backtrack(n, numOfLeftP + 1, numOfRightP, sb+"(");
        }

        if (numOfRightP < numOfLeftP){
            backtrack(n, numOfLeftP, numOfRightP + 1, sb+")");
        }
    }

    public static void main(String[] args) {
        GenerateParentheses_22 g = new GenerateParentheses_22();
        g.generateParenthesis(3);
    }
}
     