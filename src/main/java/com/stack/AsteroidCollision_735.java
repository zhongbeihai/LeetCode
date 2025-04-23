package com.stack;

import java.util.Stack;

public class AsteroidCollision_735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid: asteroids){
            if (stack.isEmpty()) {
                stack.push(asteroid);
                continue;
            }

            boolean push = true;
            while (!stack.isEmpty() && stack.peek() > 0 &&  asteroid < 0){
                int s = Math.abs(stack.peek()), a = Math.abs(asteroid);
                if (s < a){
                    stack.pop();
                }else if (s == a){
                    stack.pop();
                    push = false;
                    break;
                }else {
                    push = false;
                    break;
                }
            }
            if (push) stack.push(asteroid);
        }

        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >=0 ; i--){
            res[i] = stack.pop();
        }

        return res;
    }

    public static void main(String[] args) {
        AsteroidCollision_735 a = new AsteroidCollision_735();
        a.asteroidCollision(new int[]{-2,-1,1,2});
    }
}
