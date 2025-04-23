package com.dynamic_programming;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Candy_135 {
    public int candy(int[] ratings) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> ratings[o1] - ratings[o2]);
        int[] dis = new int[ratings.length];
        int res = 0;
        for (int i = 0; i < ratings.length; i++){
            queue.add(i);
            dis[i]++;
            res++;
        }

        while (!queue.isEmpty()){
            int c = queue.poll();
            while (c - 1 >= 0 && ratings[c] > ratings[c -1] && dis[c] <= dis[c - 1]) {
                res += dis[c - 1] - dis[c] + 1;
                dis[c] = dis[c - 1] + 1;

            }
            while (c + 1 < ratings.length && ratings[c] > ratings[c + 1] && dis[c] <= dis[c + 1]){
                res += dis[c + 1] - dis[c] + 1;
                dis[c] = dis[c + 1] + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Candy_135 c = new Candy_135();
        c.candy(new int[]{1,0,2});
    }
}
