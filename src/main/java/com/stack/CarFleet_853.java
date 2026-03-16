package com.stack;

import java.util.*;

public class CarFleet_853 {
    public int carFleet(int target, int[] position, int[] speed) {
        Deque<Integer> stack= new ArrayDeque<>();
        List<int[]> carAndSpeed = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            carAndSpeed.add(new int[]{position[i], speed[i]});
        }
        carAndSpeed.sort(Comparator.comparingInt(i -> -i[0]));
        for (int i = 0; i < position.length; i++) {
            int[] car = carAndSpeed.get(i);
            int timeNeed = (target - car[0]) / car[1];
            if (stack.isEmpty() || timeNeed > stack.peek()) stack.push(timeNeed);
        }

        return stack.size();
    }
}
