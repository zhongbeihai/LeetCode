package com.search;

import java.util.*;

public class FindAllPeopleWithSecret_2092 {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] m : meetings){
            adj.get(m[0]).add(new int[]{m[1], m[2]});
            adj.get((m[1])).add(new int[]{m[0], m[2]});
        }
        int[] earliest = new int[n];
        Arrays.fill(earliest, Integer.MAX_VALUE);

        earliest[0] = 0;
        earliest[firstPerson] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i[1]));
        pq.add(new int[]{0, 0});
        pq.add(new int[]{firstPerson, 0});

        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            int curNode = cur[0], curTime = cur[1];
            if (curTime > earliest[curNode]) continue;
            earliest[curNode] = curTime;

            for (int[] nei: adj.get(curNode)){
                if (curTime <= nei[1] && curTime < earliest[nei[0]]) pq.add(nei);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i =0; i< n; i++){
            if (earliest[i] != Integer.MAX_VALUE) res.add(i);
        }

        return res;
    }

    public static void main(String[] args) {
        FindAllPeopleWithSecret_2092 f = new FindAllPeopleWithSecret_2092();
        f.findAllPeople(4, new int[][]{{3,1,3},{1,2,2},{0,3,3}}, 3);
    }
}
