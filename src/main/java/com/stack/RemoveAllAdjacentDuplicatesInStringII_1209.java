package com.stack;

import structure.Pair;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInStringII_1209 {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character, Integer>> stack = new Stack<>();

        for (char c: s.toCharArray()){
            if (stack.isEmpty() ) {stack.push(new Pair<>(c, 1)); continue;}

            Pair<Character, Integer> p = stack.peek();
            if (c == p.getKey()){
                if (p.getValue() == k - 1){
                    for (int i = 0; i < k - 1; i++) stack.pop();
                }else {
                    stack.push(new Pair<>(c, p.getValue() + 1));
                }
            }else {
                stack.push(new Pair<>(c, 1));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop().getKey());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInStringII_1209 r = new RemoveAllAdjacentDuplicatesInStringII_1209();
        r.removeDuplicates("abcd", 2);
    }
}
