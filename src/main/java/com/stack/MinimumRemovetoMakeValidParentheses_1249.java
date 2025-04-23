package com.stack;

import java.util.Stack;

public class MinimumRemovetoMakeValidParentheses_1249 {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') continue;
            else if(stack.isEmpty()) stack.push(i);
            else if(s.charAt(i) == '(') stack.push(i);
            else if(s.charAt(i) == ')'){
                if (s.charAt(stack.peek()) == '('){
                    stack.pop();
                }else {
                    stack.push(i);
                }
            }
        }
        StringBuilder sb  = new StringBuilder(s);
        while(!stack.isEmpty()){
            sb.deleteCharAt(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MinimumRemovetoMakeValidParentheses_1249 m = new MinimumRemovetoMakeValidParentheses_1249();
        m.minRemoveToMakeValid("))((");
    }
}
