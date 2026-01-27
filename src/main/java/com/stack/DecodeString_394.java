package com.stack;

import structure.Pair;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class DecodeString_394 {
    public String decodeString(String s) {
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<StringBuffer> stringStack = new ArrayDeque<>();

        int num = 0;
        StringBuffer curBuilder = new StringBuffer();
        for(char c: s.toCharArray()){
            if (Character.isDigit(c)){
                num = num * 10 + c - '0';
            } else if (c == '[') {
                numStack.push(num);
                stringStack.push(curBuilder);

                curBuilder = new StringBuffer();
                num = 0;
            }else if(Character.isLetter(c)){
                curBuilder.append(c);
            }else if (c == ']'){
                int rep = numStack.poll();
                String base = curBuilder.toString();
                for (int i = 1; i < rep; i++) {
                    curBuilder.append(base);
                }

                StringBuffer prev = stringStack.pop();
                prev.append(curBuilder);
                curBuilder = prev;
            }
        }

        return curBuilder.toString();
    }

    public static void main(String[] args) {
        DecodeString_394 d = new DecodeString_394();
        d.decodeString("3[a2[c]]");
    }
}
