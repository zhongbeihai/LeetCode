package com.stack;

import javafx.util.Pair;

import java.util.Stack;

public class RemoveAllOccurencesOfASubsrting_1910 {
    public String removeOccurrences(String s, String part) {
        char[] sc = s.toCharArray();
        Stack<String> stack = new Stack<>();
        for (char c : sc) {
            if (String.valueOf(c).equals(part)) continue;
            if (stack.isEmpty()) {
                stack.push(String.valueOf(c));
                continue;
            }
            String top = stack.pop();
            String n = top + c;
            if (part.equals(n)) continue;
            if (part.startsWith(n)) {
                stack.push(n);
            } else {
                stack.push(top);
                stack.push(String.valueOf(c));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            String rb = new StringBuilder(stack.pop()).reverse().toString();
            sb.append(rb);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        RemoveAllOccurencesOfASubsrting_1910 r = new RemoveAllOccurencesOfASubsrting_1910();
        r.removeOccurrences("daabcbaabcbc","abc");
    }
}
