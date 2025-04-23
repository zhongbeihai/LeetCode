package com.stack;

import java.util.Stack;

public class MinimumAddToMakeParentheseVaild_921 {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
                continue;
            }
            if(s.charAt(i) == ')' && stack.peek() == '('){
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }

        return stack.size();
    }

    public static void main(String[] args) {
        MinimumAddToMakeParentheseVaild_921 m = new MinimumAddToMakeParentheseVaild_921();
        m.minAddToMakeValid("()))((");
    }
}
