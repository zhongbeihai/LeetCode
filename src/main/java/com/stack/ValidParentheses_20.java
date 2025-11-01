package com.stack;

import java.util.Stack;

// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
// determine if the input string is valid.
public class ValidParentheses_20 {
    public boolean isValid(String s) {
        char[] ss = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c: ss){
            if (stack.isEmpty() || c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }
            if (c == ')'){
                char top = stack.peek();
                if (top == '(') stack.pop();
                else if (top == '{' || top == '[') return false;
                else stack.push(c);
            } else if (c == '}') {
                char top = stack.peek();
                if (top == '{') stack.pop();
                else if (top == '(' || top == '[') return false;
                else stack.push(c);
            } else if (c == ']') {
                char top = stack.peek();
                if (top == '[') stack.pop();
                else if (top == '{' || top == '(') return false;
                else stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
