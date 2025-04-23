package com.dynamic_programming;

import java.util.Arrays;
import java.util.Stack;

public class MinimumTimeToMakeRopeColorful_1578 {
    public int minCost(String colors, int[] neededTime) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        stack.push(0);
        for(int i = 1; i < colors.length(); i++){
            int head = stack.pop();
            if(colors.charAt(head) != colors.charAt(i)){
                stack.push(head);
                stack.push(i);
            }else {
                if(neededTime[head] > neededTime[i]){
                    sum += neededTime[i];
                    stack.push(head);
                }else {
                    sum += neededTime[head];
                    stack.push(i);
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        MinimumTimeToMakeRopeColorful_1578 m = new MinimumTimeToMakeRopeColorful_1578();
        m.minCost("bbbaaa", new int[]{4,9,3,8,8,9});
    }
}
