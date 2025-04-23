package com.stack;

import java.util.Stack;

public class BasicCalculator_227 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] ss = s.toCharArray();
        int startPos = 0;
        while (ss[startPos] == ' ') startPos++;
        char preOpe = Character.isDigit(ss[startPos]) ? '+' : ss[startPos];
        int num = 0;
        for (int i = startPos; i <= ss.length; i++){
            char c = i < ss.length ? ss[i] : '\0';
            if (c == ' ') continue;
            if (Character.isDigit(c))
                num = num * 10 + (c - '0');
            if ((!Character.isDigit(c) && c != ' ') || i == ss.length){
                if (preOpe == '+') stack.push(num);
                else if (preOpe == '-') stack.push(-num);
                else if (preOpe == '*') stack.push(stack.pop() * num);
                else if (preOpe == '/') stack.push(stack.pop() / num);
                preOpe = c;
                num = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        BasicCalculator_227 b = new BasicCalculator_227();
        b.calculate("42");
    }
}
