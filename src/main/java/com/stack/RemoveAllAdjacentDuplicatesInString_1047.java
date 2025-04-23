package com.stack;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * You are given a string s consisting of lowercase English letters.
 * A duplicate removal consists of choosing two adjacent and equal letters and removing them.
 * We repeatedly make duplicate removals on s until we no longer can.
 * Input: s = "abbaca"
 * Output: "ca"
 */
public class RemoveAllAdjacentDuplicatesInString_1047 {
    public String removeDuplicates(String s) {
        char[] ss = s.toCharArray();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < ss.length; i++){
            if(stack.size() == 0 || ss[stack.peek()] != ss[i]){
                stack.push(i);
            }else{
                stack.pop();
            }
        }

        LinkedList<Integer> list = new LinkedList<>();
        int size = stack.size();
        for(int i = 0; i < size; i++){
            list.addFirst(stack.pop());
        }

        StringBuffer sb = new StringBuffer();
        for(int i: list){
            sb.append(ss[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInString_1047 r = new RemoveAllAdjacentDuplicatesInString_1047();
        r.removeDuplicates("abbaca");
    }
}
