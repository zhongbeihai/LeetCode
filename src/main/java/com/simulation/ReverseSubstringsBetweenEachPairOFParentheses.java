package com.simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ReverseSubstringsBetweenEachPairOFParentheses {
    public String reverseParentheses(String s) {
        ArrayList<Integer> left = new ArrayList();
        ArrayList<Integer> right = new ArrayList();

        Stack<Integer> stack = new Stack();
        char[] sc = s.toCharArray();
        for(int i = 0; i < sc.length; i++){
            if(sc[i] == '(') stack.push(i);
            if(sc[i] == ')') {
                reverse(sc, stack.pop(), i);
            }

            //reverse(sc, left.get(i), right.get(right.size()- i - 1));
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < sc.length; i++){
            if(sc[i] != '(' && sc[i] != ')'){
                sb.append(sc[i]);
            }
        }
        return sb.toString();
    }

    public char[] reverse(char[] s, int start, int end) {
        int left = start, right = end;
        while(left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
        return s;
    }

    public static void main(String[] args) {
        ReverseSubstringsBetweenEachPairOFParentheses r =  new ReverseSubstringsBetweenEachPairOFParentheses();
        r.reverseParentheses("ta()usw((((a))))");
    }
}
