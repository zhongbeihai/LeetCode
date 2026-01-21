package com.dynamic_programming;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortIntegersByThePowerValue_1387 {
    public int getKth(int lo, int hi, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((i , j) -> {
            if (i[1] == j[1] ) return i[0] - j[0];
            else return i[1] - j[1];
        }); // {number, power}
        Map<Integer, Integer> powerMap = new HashMap<>();

        for (int i = lo; i <= hi ; i++) {
            int power = getPower(i, powerMap);
            pq.add(new int[]{i, power});
        }

        while (k > 1) {
            pq.poll();
            k--;
        }

        return pq.poll()[0];
    }

    public int getPower(int num, Map<Integer, Integer> powerMap){
        if (num == 1) return 0;
        if (powerMap.containsKey(num)) return powerMap.get(num);

        int power =  num % 2 == 0 ? getPower(num / 2, powerMap) + 1 : getPower(num * 3 + 1, powerMap) + 1;
        powerMap.put(num, power);

        return power;
    }

    public static void main(String[] args) {
        SortIntegersByThePowerValue_1387 s = new SortIntegersByThePowerValue_1387();
        s.getKth(10, 20, 5);
    }
}
