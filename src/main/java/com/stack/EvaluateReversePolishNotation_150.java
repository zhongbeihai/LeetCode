package com.stack;

import java.awt.*;
import java.util.Objects;
import java.util.Stack;

/**
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 */
public class EvaluateReversePolishNotation_150 {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < tokens.length; i++){
            if(Objects.equals(tokens[i], "+") || Objects.equals(tokens[i], "-") ||
                    Objects.equals(tokens[i], "/") || Objects.equals(tokens[i], "*")){
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                if(Objects.equals(tokens[i], "+")) stack.push(Integer.toString(num2 + num1));
                if(Objects.equals(tokens[i], "-")) stack.push(Integer.toString(num2 - num1));
                if(Objects.equals(tokens[i], "/")) stack.push(Integer.toString(num2 / num1));
                if(Objects.equals(tokens[i], "*")) stack.push(Integer.toString(num2 * num1));
            }else {
                stack.push(tokens[i]);
            }

        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation_150 e = new EvaluateReversePolishNotation_150();
        System.out.println(e.evalRPN(new String[]{"2","1","+","3","*"}));
    }
}
