package com.monotonic_stack;

import java.util.*;

/**
 * Given a string s, remove duplicate letters so that every letter appears once and only once.
 * You must make sure your result is the smallest in lexicographical order
 *  among all possible results.
 */
public class RemoveDuplicateLetters_316 {

    public String removeDuplicateLetters(String s) {
        char[] ss = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        HashSet<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (char i : ss){
            set.add(i);
        }

        for(Iterator<Character> it = set.iterator(); it.hasNext();){
            Character c = it.next();
            while (!stack.isEmpty() && c < stack.peek()){
                sb.append(stack.pop());
            }
            stack.push(c);
        }

        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
