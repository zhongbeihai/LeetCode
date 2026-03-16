package com.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class RemoveKDigits_402 {
    // 1432219
    // 1 -> 12 -> 121 -> 1219
    public String removeKdigits(String num, int k) {
        if (num.length() <= k) return "0";
        Deque<Integer> stack = new ArrayDeque<>();

        for (char c: num.toCharArray()){
            if (stack.isEmpty() || c - '0' >= stack.peek()) stack.push(c - '0');
            else {
                while (!stack.isEmpty() && c - '0' < stack.peek() && k > 0){
                    stack.pop();
                    k--;
                }
                stack.push(c - '0');
            }
        }

        while (!stack.isEmpty() && k > 0){
            stack.removeLast();
            k--;
        }

        while (!stack.isEmpty() && stack.peekFirst() == 0) stack.removeFirst();
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pollLast());

        return sb.length() == 0 ? "0" : sb.toString();
    }

}
