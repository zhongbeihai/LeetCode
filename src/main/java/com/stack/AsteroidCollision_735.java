package com.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class AsteroidCollision_735 {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids.length == 0) return new int[0];

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < asteroids.length; i++){
            boolean push = true;
            while (!stack.isEmpty() && stack.peek() > 0 && asteroids[i] < 0){
                int last = Math.abs(stack.peek()), cur = Math.abs(asteroids[i]);
                if (last < cur) stack.pop();
                else {
                    if (last == cur) stack.pop();
                    push = false;
                    break;
                }
            }
            if (push) stack.push(asteroids[i]);
        }

        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--){
            res[i] = stack.pop();
        }

        return res;
    }

    public static void main(String[] args) {
        AsteroidCollision_735 a = new AsteroidCollision_735();
        a.asteroidCollision(new int[]{5,10,-5});
    }
}
