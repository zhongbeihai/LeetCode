package com.dequeue_and_priorityqueue;

import java.util.*;

public class MinimumCostToHireKWorkers_857 {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        List<double[]> ratios = new ArrayList<>();

        for (int i = 0; i < quality.length; i++) {
            ratios.add(new double[]{quality[i], (double) wage[i] / quality[i]});
        }
        ratios.sort(Comparator.comparing(i -> i[1]));

        PriorityQueue<double[]> pq = new PriorityQueue<>(Comparator.comparingDouble(i -> -i[0]));
        double res = Double.MAX_VALUE;

        double qualitiesSum = 0, curMaxRatio = 0;
        for (double[] r: ratios){
            pq.add(r);
            qualitiesSum += r[0];

            while (pq.size() > k){
                qualitiesSum -= pq.poll()[0];
            }

            curMaxRatio = r[1];
            if(pq.size() == k) res = Math.min(res, curMaxRatio * qualitiesSum);
        }

        return res;
    }

    public static void main(String[] args) {
        MinimumCostToHireKWorkers_857 m = new MinimumCostToHireKWorkers_857();
        m.mincostToHireWorkers(new int[]{10,20,5}, new int[]{70, 50, 30}, 2);
    }
}
