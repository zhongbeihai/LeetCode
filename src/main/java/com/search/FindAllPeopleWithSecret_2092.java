package com.search;

import java.util.*;

public class FindAllPeopleWithSecret_2092 {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] m: meetings){
            adj.get(m[0]).add(new int[]{m[1], m[2]});
            adj.get(m[1]).add(new int[]{m[0], m[2]});
        }

        int[] earlist = new int[n];
        Arrays.fill(earlist, Integer.MAX_VALUE);
        earlist[0] = 0;
        earlist[firstPerson] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i[1]));
        pq.add(new int[]{0, 0});
        pq.add(new int[]{firstPerson, 0});

        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            int p = cur[0], time = cur[1];
            if (time > earlist[p]) continue;

            for (int[] nei: adj.get(p)){
                int next = nei[0], meetTime = nei[1];
                if (earlist[next] > meetTime && meetTime >= time) {
                    earlist[next] = meetTime;
                    pq.add(new int[]{next, meetTime});
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (earlist[i] != Integer.MAX_VALUE) res.add(i);
        }

        return res;
    }

    public static void main(String[] args) {
        FindAllPeopleWithSecret_2092 f = new FindAllPeopleWithSecret_2092();
        f.findAllPeople(4, new int[][]{{3,1,3},{1,2,2},{0,3,3}}, 3);
    }
}
