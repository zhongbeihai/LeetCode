package com.stack;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.Stack;

/**
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 */
public class EvaluateReversePolishNotation_150 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token: tokens){
            if (token.equals("+")){
                int sec = stack.pop(), fir = stack.pop();
                stack.push(sec + fir);
            } else if (token.equals("*")) {
                int sec = stack.pop(), fir = stack.pop();
                stack.push(sec * fir);
            } else if (token.equals("/")) {
                int sec = stack.pop(), fir = stack.pop();
                stack.push(fir / sec);
            } else if (token.equals("-")) {
                int sec = stack.pop(), fir = stack.pop();
                stack.push(fir - sec);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation_150 e = new EvaluateReversePolishNotation_150();
        System.out.println(e.evalRPN(new String[]{"2","1","+","3","*"}));
    }
}
