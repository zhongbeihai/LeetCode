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
        if (s.isEmpty()) return 0;

        Stack<Integer> stack = new Stack<>();

        int maxL = 0;
        for (int i = 0; i < s.length(); i++){
            if (stack.isEmpty() || s.charAt(i) == '(') stack.push(i);
            else {
                if (s.charAt(stack.peek()) == ')') stack.push(i);
                else {
                    stack.pop();
                    int l = stack.isEmpty() ? -1 : stack.peek();
                    maxL = Math.max(maxL, i - l);
                }
            }
        }

        return maxL;
    }

    public static void main(String[] args) {
        LongestValidParentheses_32 l = new LongestValidParentheses_32();
        l.longestValidParentheses(")()())");
    }
}
