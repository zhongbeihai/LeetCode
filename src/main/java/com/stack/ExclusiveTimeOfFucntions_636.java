package com.stack;

import java.util.*;

public class ExclusiveTimeOfFucntions_636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        int prevTime = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (String log: logs){
            String[] ss = log.split(":");
            int id = Integer.parseInt(ss[0]), curTime = Integer.parseInt(ss[2]);
            boolean isStart = ss[1].charAt(0) == 's';

            if (isStart){
                if (!stack.isEmpty()) res[stack.peek()] += curTime - prevTime;
                stack.push(id);
                prevTime = curTime;
            }else {
                stack.pop();
                res[id] += curTime - prevTime + 1;
                prevTime = curTime + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        ExclusiveTimeOfFucntions_636 e = new ExclusiveTimeOfFucntions_636();
        e.exclusiveTime(2, Arrays.asList("0:start:0","1:start:2","1:end:5","0:end:6"));
    }
}
