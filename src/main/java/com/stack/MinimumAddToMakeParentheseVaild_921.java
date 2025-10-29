package com.stack;

import java.util.Stack;

public class MinimumAddToMakeParentheseVaild_921 {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] ss = s.toCharArray();
        for (char c: ss){
            if (stack.isEmpty() || c == '(') {stack.push(c); continue;}
            if (c == ')'){
                if (stack.peek() == '(') stack.pop();
                else stack.push(c);
            }
        }

        return stack.size();
    }

    public static void main(String[] args) {
        MinimumAddToMakeParentheseVaild_921 m = new MinimumAddToMakeParentheseVaild_921();
        m.minAddToMakeValid("()))((");
    }
}
