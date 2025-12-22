package com.stack;

import structure.Pair;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class DecodeString_394 {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        int num = 0;
        StringBuilder cur = new StringBuilder();
        for (char c: s.toCharArray()){
            if (Character.isDigit(c)){
                num = num * 10 + c - '0';
            } else if (c == '[') {
                numStack.push(num);
                stringStack.push(cur);
                cur = new StringBuilder();
                num = 0;
            } else if (c == ']') {
                StringBuilder prev = stringStack.pop();
                int times = numStack.pop();
                for (int i = 0; i < times; i++){
                    prev.append(cur);
                }
                cur = prev;
            }else {
                cur.append(c);
            }
        }

        return stringStack.pop().toString();
    }

    public static void main(String[] args) {
        DecodeString_394 d = new DecodeString_394();
        d.decodeString("3[a2[c]]");
    }
}
