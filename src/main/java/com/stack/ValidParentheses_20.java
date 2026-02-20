package com.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
// determine if the input string is valid.
public class ValidParentheses_20 {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c: s.toCharArray()){
            if (stack.isEmpty() || c == '(' || c == '[' || c == '{') stack.push(c);
            else if (c == ')' && stack.peek() == '(') stack.pop();
            else if (c == '}' && stack.peek() == '{') stack.pop();
            else if (c == ']' && stack.peek() == '[') stack.pop();
            else return false;
        }

        return stack.isEmpty();
    }
}
