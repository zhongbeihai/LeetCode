package com.stack;

import java.util.ArrayDeque;

public class ReverseSubstringsBetweenEachPairOfParentheses_1190 {
    public String reverseParentheses(String s) {
        ArrayDeque<StringBuilder> stack = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        for (char c: s.toCharArray()){
            if (c == '('){
                stack.push(sb);
                sb = new StringBuilder();
            }else if (c == ')'){
                sb.reverse();
                StringBuilder lastBuilder = stack.pop();
                lastBuilder.append(sb);

                sb = lastBuilder;
            }else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
