package com.stack;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')',
 * return the length of the longest valid (well-formed) parentheses substring
 * Input: s = ")()())"
 * Output: 4
 * **the top the stack is the first **index** of invalid element**
 */
public class LongestValidParentheses_32 {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] ss = s.toCharArray();

        // initialize the stack
        // **the top the stack is the first **index** of invalid element**
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < ss.length; i++){
            if(ss[i] == '(' || stack.peek() == -1) stack.push(i);
            if(ss[i] == ')'){
                if(ss[stack.peek()] == '('){
                    stack.pop();
                    max = Math.max(max, i - stack.peek());
                }else {
                    stack.push(i);
                }
            }
        }

        return max;
    }
}
