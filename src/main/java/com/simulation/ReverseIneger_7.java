package com.simulation;

import java.util.Stack;

public class ReverseIneger_7 {
    public int reverse(int x) {
        Stack<Integer> stack = new Stack<>();

        char[] xx = String.valueOf(x).toCharArray();
        for (int i = 0; i < xx.length; i++) {
            if (Character.isDigit(xx[i])) stack.push(i);
        }


        if (!stack.isEmpty() && xx[stack.peek()] == 0) stack.pop();
        long res = 0;
        while (!stack.isEmpty()){
            res = res * 10 + xx[stack.pop()] - '0';
            if (res > Integer.MAX_VALUE) return 0;
        }

        if (x < 0) res = -res;
        if (res < Integer.MIN_VALUE) return 0;

        return Math.toIntExact(res);
    }

    public static void main(String[] args) {
        ReverseIneger_7 r = new ReverseIneger_7();
        r.reverse(1534236469);
    }
}
