package com.stack;

import java.util.*;

public class ExclusiveTimeOfFucntions_636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevTime = 0;
        for (String log: logs){
            String[] l = log.split(":");
            int id = Integer.parseInt(l[0]), time = Integer.parseInt(l[2]);
            if (l[1].equals("start")) {
                if (!stack.isEmpty()){
                    res[stack.peek()] += time - prevTime;
                }
                stack.push(id);
                prevTime = time;
            }else {
                stack.pop();
                res[id] += time - prevTime + 1;
                prevTime = time + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        ExclusiveTimeOfFucntions_636 e = new ExclusiveTimeOfFucntions_636();
        e.exclusiveTime(2, Arrays.asList("0:start:0","1:start:2","1:end:5","0:end:6"));
    }
}
