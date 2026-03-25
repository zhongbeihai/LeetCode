package com.stack;

import structure.Pair;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class DecodeString_394 {
    public String decodeString(String s) {
        ArrayDeque<Integer> numStack = new ArrayDeque<>();
        ArrayDeque<StringBuilder> stringStack = new ArrayDeque<>();

        StringBuilder cur = new StringBuilder();
        int num = 0;
        for (char c: s.toCharArray()){
            if (Character.isDigit(c)){
                num = num * 10 + c - '0';
            } else if (Character.isLetter(c)) {
                cur.append(c);
            } else if (c == '[') {
                numStack.push(num);
                num = 0;
                stringStack.push(cur);
                cur = new StringBuilder();
            }else if (c == ']'){
                int r = numStack.pop();
                String basic = cur.toString();
                for (int i = 1; i < r; i++) {
                    cur.append(basic);
                }
                StringBuilder lastBuilder = stringStack.pop();
                lastBuilder.append(cur);
                cur = lastBuilder;
            }
        }

        return cur.toString();
    }

    public static void main(String[] args) {
        DecodeString_394 d = new DecodeString_394();
        d.decodeString("3[a2[c]]");
    }
}
