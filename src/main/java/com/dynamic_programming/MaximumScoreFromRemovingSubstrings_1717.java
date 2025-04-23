package com.dynamic_programming;



import java.util.Collections;
import java.util.Stack;

public class MaximumScoreFromRemovingSubstrings_1717 {
    public int maximumGain(String s, int x, int y) {
        String reverseS = new StringBuffer(s).reverse().toString();
        return x > y ? count(s, x, y) : count(reverseS, y, x);
    }

    public int count(String s, int x, int y){
        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        for(int i = 0; i < s.length(); i++){
            if (!stack.isEmpty() && stack.peek() == 'a' && s.charAt(i) == 'b'){
                stack.pop();
                cnt += x;
            }else {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        stack.forEach(sb::append);
        s = sb.toString();
        stack.clear();
        for(int i = 0; i < s.length(); i++){
            if (!stack.isEmpty() && stack.peek() == 'b' && s.charAt(i) == 'a'){
                stack.pop();
                cnt += y;
            }else {
                stack.push(s.charAt(i));
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        MaximumScoreFromRemovingSubstrings_1717 m = new MaximumScoreFromRemovingSubstrings_1717();
        m.maximumGain("cdbcbbaaabab", 4, 5);
    }
}
