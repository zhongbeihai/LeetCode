package com.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class DecodeString_394 {
    public String decodeString(String s) {
        Deque<Integer> counts = new ArrayDeque<>();
        Deque<StringBuilder> stack = new ArrayDeque<>();

        char[] ss = s.toCharArray();
        int num = 0;
        StringBuilder curStringBuilder = new StringBuilder();
        for (char curChar: ss){
            if (Character.isDigit(curChar)){
                num = num * 10 + curChar - '0';
            } else if (curChar == '[') {
                counts.push(num);
                stack.push(curStringBuilder);
                curStringBuilder = new StringBuilder();
                num = 0;
            } else if (curChar == ']') {
                int times = counts.pop();
                StringBuilder prev = stack.pop();
                for (int i = 0; i < times; i++) {
                    prev.append(curStringBuilder);
                }
                curStringBuilder = prev;
            }else {
                curStringBuilder.append(curChar);
            }
        }

        return curStringBuilder.toString();
    }

    public static void main(String[] args) {
        DecodeString_394 d = new DecodeString_394();
        d.decodeString("3[a2[c]]");
    }
}
