package com.monotonic_stack;


import java.util.*;

/**
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to
 * wait after the ith day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 */
public class DailyTemperature_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        // put the index into the monotonic stack
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        int count = 0;
        for(int i = 0; i < temperatures.length; i++){
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                System.out.println(temperatures[stack.peek()] +" < " +temperatures[i]);
                res[stack.peek()] = i - stack.pop();
            }
            stack.add(i);
        }

        return res;
    }

    public static void main(String[] args) {
        DailyTemperature_739 dailyTemperature_739 = new DailyTemperature_739();
        System.out.println(dailyTemperature_739.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73}));
    }
}
