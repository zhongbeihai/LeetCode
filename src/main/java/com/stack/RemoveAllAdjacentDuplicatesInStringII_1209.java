package com.stack;

import structure.Pair;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInStringII_1209 {
    public String removeDuplicates(String s, int k) {
        Deque<int[]> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() || s.charAt(i) != s.charAt(stack.peek()[0])){
                stack.push(new int[]{i, 1});
            }else {
                if (stack.peek()[1] == k - 1)stack.pop();
                else {
                    stack.peek()[1] += 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            int[] top = stack.pop();
            for (int i = 0; i < top[1]; i++) {
                sb.append(s.charAt(top[0]));
            }
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInStringII_1209 r = new RemoveAllAdjacentDuplicatesInStringII_1209();
        r.removeDuplicates("abcd", 2);
    }
}
