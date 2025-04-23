package com.divided;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParenthese_241 {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        if(!expression.contains("+") && !expression.contains("-") && !expression.contains("*")){
            res.add(Integer.parseInt(expression));
            return res;
        }
        for(int i = 0; i < expression.length(); i++){
            if(expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*'){
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i+1));
                for(int j = 0; j < left.size(); j++){
                    for(int k = 0; k < right.size(); k++){
                        if(expression.charAt(i) == '+') res.add(left.get(j) + right.get(k));
                        else if(expression.charAt(i) == '*') res.add(left.get(j) * right.get(k));
                        else res.add(left.get(j) - right.get(k));
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        DifferentWaysToAddParenthese_241 d = new DifferentWaysToAddParenthese_241();
        d.diffWaysToCompute("2-1-1");
    }
}
