package com.simulation;

import java.util.Stack;

public class ReverseIneger_7 {
    public int reverse(int x) {
        Stack<Character> stack = new Stack<>();
        char[] ca = String.valueOf(x).toCharArray();
        for (char c: ca){
            stack.push(c);
        }

        while (!stack.isEmpty() && stack.peek() == '0') stack.pop();
        if (stack.isEmpty()) return 0;
        long res = 0;
        while (!stack.isEmpty() && stack.peek() != '-'){
            res = res * 10 + stack.pop() - '0';
            try {
                int z = Math.toIntExact(res);
            }catch (ArithmeticException ex){
                return 0;
            }
        }
        if (!stack.isEmpty() && stack.peek() == '-') res = -res;

        return (int) res;
    }

    public static void main(String[] args) {
        ReverseIneger_7 r = new ReverseIneger_7();
        r.reverse(-1230);
    }
}
