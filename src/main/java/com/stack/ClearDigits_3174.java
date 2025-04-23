package com.stack;

import java.util.Stack;

public class ClearDigits_3174 {
    public String clearDigits(String s) {
        if(s.isEmpty()) return "";
        Stack<Integer> stack = new Stack<>();

        char[] ss = s.toCharArray();
        for (int i = 0; i < s.length(); i++){
            if (!stack.isEmpty() && Character.isDigit(ss[i]) && Character.isLetter(ss[stack.peek()])){
                stack.pop();
            } else if (!stack.isEmpty() && Character.isLetter(ss[i]) && Character.isDigit(ss[stack.peek()])) {
                stack.pop();
            }else {
                stack.push(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(ss[stack.pop()]);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        ClearDigits_3174 c = new ClearDigits_3174();
        c.clearDigits("abc");
    }
}
