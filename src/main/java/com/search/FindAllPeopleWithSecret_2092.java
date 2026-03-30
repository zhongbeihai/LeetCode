package com.search;

import java.util.*;

public class FindAllPeopleWithSecret_2092 {
    // sort meetings in the order of time
    // use an array to mark the people who have known the secrets
    // union all people that having meeting at time t
    // if one of them has known the secrets -> all the people will know the secret
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, Comparator.comparingInt(i -> i[2]));

        UnionFind uf = new UnionFind(n);
        uf.union(0, firstPerson);

        int i = 0;
        while (i < meetings.length){
            int time = meetings[i][2];

            // group all the meetings at the ``time``
            List<int[]> group = new ArrayList<>();
            while (i < meetings.length && meetings[i][2] == time){
                group.add(meetings[i]);
                i++;
            }

            Set<Integer> people = new HashSet<>();
            for (int[] m: group) {
                uf.union(m[0], m[1]);
                people.add(m[0]);
                people.add(m[1]);
            }

            for (int p: people){
                if (!uf.connected(p, 0)) uf.reset(p);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            if (uf.connected(j, 0)) res.add(j);
        }

        return res;
    }

    class UnionFind{
        int[] parent;
        public UnionFind(int n){
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        public int find(int x){
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        public void union(int x, int y){
            int px = find(x), py = find(y);
            if (px != py) parent[px] = py;
        }

        public boolean connected(int x, int y){
            return find(x) == find(y);
        }

        public void reset(int x){
            parent[x] = x;
        }
    }

    public static void main(String[] args) {
        FindAllPeopleWithSecret_2092 f = new FindAllPeopleWithSecret_2092();
        f.findAllPeople(4, new int[][]{{3,1,3},{1,2,2},{0,3,3}}, 3);
    }
}
