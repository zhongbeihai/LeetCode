package com.backtrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {
    private List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        recursion(0, 0 , n, "");
        return res;
    }

    public void recursion(int left, int right, int n, String tem){
        if(tem.length() == n * 2){
            res.add(tem);
            return;
        }

        if(left < n){
            recursion(left+1, right, n, tem + "(");
        }

        if(right < left){
            recursion(left, right+1, n, tem + ")");
        }

    }

    public static void main(String[] args) {
        GenerateParentheses_22 g = new GenerateParentheses_22();
        g.generateParenthesis(3);
    }
}
     