package com.stack;

import com.simulation.CountGoodNumbers_1922;

import java.util.Stack;

public class CountCollisionOnARoad_2211 {
    public int countCollisions(String directions) {
        Stack<Character> stack = new Stack<>();

        int res = 0;
        for (char c: directions.toCharArray()){
            if (c == 'S'){
                while (!stack.isEmpty() && stack.peek() == 'R'){
                    res++;
                    stack.pop();
                }
            }else if (c == 'L'){
                if (!stack.isEmpty() && stack.peek() == 'S'){
                    res++;
                    continue;
                } else if (!stack.isEmpty() && stack.peek() == 'R') {
                    res += 2;
                    stack.pop();
                    while (!stack.isEmpty() && stack.peek() == 'R'){
                        stack.pop();
                        res++;
                    }
                    stack.push('S');
                    continue;
                }
            }
            stack.push(c);
        }

        return res;
    }

    public static void main(String[] args) {
        CountCollisionOnARoad_2211 c = new CountCollisionOnARoad_2211();
        c.countCollisions("RRRRLLRR");
    }
}
