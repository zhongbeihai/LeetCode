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
    // max heap, size at most k
    // we maintain the points in the order distance(from closest to farthest)
    // when the size exceed k -> pop out the fartest point
    public int[][] kClosest(int[][] points, int k) {
        // define a max heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((i, j) -> {
            return -Long.compare(getDist(i), getDist(j));
        });

        // traverse all the points
        for (int[] p: points){
            pq.add(p);

            // when the size exceed k
            while (pq.size() > k){
                pq.poll();
            }
        }

        int[][] res = new int[pq.size()][];
        int i =0;
        while (!pq.isEmpty()){
            res[i++] = pq.poll();
        }

        return res;
    }

    public long getDist(int[] a){
        return (long) a[0] * a[0] + (long) a[1] * a[1]; // don't need to cal the sqrt root
    }
}
