package com.stack;

import structure.Pair;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class DecodeString_394 {
    public String decodeString(String s) {
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<StringBuilder> strStack = new ArrayDeque<>();

        StringBuilder curBuilder = new StringBuilder();
        char[] ss = s.toCharArray();
        int num = 0;
        for (char c: ss){
            if (Character.isDigit(c)){
                num = num * 10 + c - '0';
            } else if (c == '[') {
                strStack.push(curBuilder);
                curBuilder = new StringBuilder();
                numStack.push(num);
                num = 0;
            } else if (Character.isLetter(c)) {
                curBuilder.append(c);
            } else if (c == ']') {
                int rep = numStack.pop();
                String base = curBuilder.toString();
                for (int i = 0; i < rep - 1; i++) {
                    curBuilder.append(base);
                }
                String curs = curBuilder.toString();
                curBuilder = strStack.pop();
                curBuilder.append(curs);
            }
        }

        return curBuilder.toString();
    }

    public static void main(String[] args) {
        DecodeString_394 d = new DecodeString_394();
        d.decodeString("3[a2[c]]");
    }
}
