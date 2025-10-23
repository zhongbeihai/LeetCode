package com.stack;

import java.util.Stack;

public class MinimumRemovetoMakeValidParentheses_1249 {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        int leftParen = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                leftParen++;
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (leftParen > 0){
                    leftParen--;
                    stack.push(i);
                }
            }else {
                stack.push(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            if (leftParen > 0 && s.charAt(stack.peek()) == '(') {
                stack.pop();
                leftParen--;
            }
            else sb.append(s.charAt(stack.pop()));
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        MinimumRemovetoMakeValidParentheses_1249 m = new MinimumRemovetoMakeValidParentheses_1249();
        m.minRemoveToMakeValid("))(((");
    }
}
