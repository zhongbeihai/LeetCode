package com.dequeue_and_priorityqueue;

import structure.Pair;

import java.util.*;

/**
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k
 * return the k closest points to the origin (0, 0).
 * The distance between two points on the X-Y plane is the Euclidean distance
 * (i.e., √(x1 - x2)2 + (y1 - y2)2).
 * Input: points = [[1,3],[-2,2]], k = 1
 * Output: [[-2,2]]
 */
public class KClosestPointsToOrigin_973 {
    public int[][] kClosest(int[][] points, int k) {
        class MyComparator implements Comparator<Pair<Integer, Integer>>{

            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                double d1 = o1.getKey() * o1.getKey() + o1.getValue() * o1.getValue();
                double d2 = o2.getKey() * o2.getKey() + o2.getValue() * o2.getValue();
                return (int) (d1 - d2);
            }
        }

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(new MyComparator());
        LinkedList<Pair<Integer, Integer>> pointSet = new LinkedList<>();
        for(int i = 0; i < points.length; i++){
            pointSet.add(new Pair<>(points[i][0], points[i][1]));
        }
        for (Iterator<Pair<Integer, Integer>> it = pointSet.iterator(); it.hasNext(); ) {
            pq.offer(it.next());
        }

        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++){
            res[i][0] = pq.peek().getKey();
            res[i][1] = pq.peek().getValue();
            pq.poll();
        }

        return res;
    }
}
