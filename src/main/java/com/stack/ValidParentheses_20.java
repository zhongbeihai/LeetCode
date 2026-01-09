package com.stack;

import java.util.Stack;

// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
// determine if the input string is valid.
public class ValidParentheses_20 {
    public boolean isValid(String s) {
       char[] ss = s.toCharArray();
       Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ss.length; i++) {
            if (stack.isEmpty()) stack.add(i);
            else if (ss[i] == '[' || ss[i] == '{' || ss[i] == '(') stack.add(i);
            else if (ss[i] == ']' && ss[stack.peek()] == '[') stack.pop();
            else if (ss[i] == '}' && ss[stack.peek()] == '{') stack.pop();
            else if (ss[i] == ')' && ss[stack.peek()] == '(') stack.pop();
            else return false;
        }

        return stack.isEmpty();
    }
}
