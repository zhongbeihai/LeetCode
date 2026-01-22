package com.stack;

import structure.Pair;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInStringII_1209 {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && s.charAt(i) == s.charAt(stack.peek()[0]) && stack.peek()[1] == k - 1){
                for (int j = 0; j < k - 1; j++) {
                    stack.pop();
                }
            }else {
                if (stack.isEmpty() || s.charAt(stack.peek()[0]) != s.charAt(i)) stack.push(new int[]{i, 1});
                else stack.push(new int[]{i, stack.peek()[1] + 1});
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(s.charAt(stack.pop()[0]));
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInStringII_1209 r = new RemoveAllAdjacentDuplicatesInStringII_1209();
        r.removeDuplicates("abcd", 2);
    }
}
