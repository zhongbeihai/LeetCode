package com.stack;

import java.util.Stack;

// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
// determine if the input string is valid.
public class ValidParentheses_20 {
    public boolean isValid(String s) {
        char[] ss = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        if(s.length() % 2 != 0) return false;
        for(char p: ss){
            if(p == '{' || p == '(' || p == '[' || stack.size() == 0){
                stack.push(p);
            } else if (p == '}') {
                if (stack.peek() == '{') {
                    stack.pop();
                }else {
                    stack.push(p);
                }
            } else if (p == ']') {
                if (stack.peek() == '[') {
                    stack.pop();
                }else {
                    stack.push(p);
                }
            } else if (p == ')') {
                if (stack.peek() == '(') {
                    stack.pop();
                }else {
                    stack.push(p);
                }
            }
        }

        return stack.size() == 0;
    }
}
