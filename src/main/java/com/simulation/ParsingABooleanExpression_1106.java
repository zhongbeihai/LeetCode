package com.simulation;

import java.util.ArrayList;
import java.util.Stack;

public class ParsingABooleanExpression_1106 {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        for(char c: expression.toCharArray()){
            if(c != ')' && c != ','){
                stack.push(c);
            }else if(c == ')'){
                ArrayList<Boolean> subExp = new ArrayList<>();
                while (!stack.isEmpty() && stack.peek() != '('){
                    char t = stack.pop();
                    if(t == 't'){
                        subExp.add(true);
                    }else {
                        subExp.add(false);
                    }
                }
                stack.pop();

                if(!stack.isEmpty()){
                    char oper = stack.pop();
                    boolean v = subExp.get(0);
                    if(oper == '&') {
                        for (boolean b: subExp) v &= b;
                    } else if (oper == '|') {
                        for (boolean b: subExp) v |= b;
                    }else if (oper == '!'){
                        for (boolean b: subExp) v = !v;
                    }
                    if(v){
                        stack.push('t');
                    }else {
                        stack.push('f');
                    }
                }

            }
        }

        return stack.peek() == 't';
    }
}
