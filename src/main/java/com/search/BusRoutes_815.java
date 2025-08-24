package com.search;

import java.util.*;

public class BusRoutes_815 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        Map<Integer, List<Integer>> stopToRoutes = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop: routes[i]){
                stopToRoutes.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<int[]> queue = new ArrayDeque<>(); //[routeIndex, busTaken]
        boolean[] visitedRoute = new boolean[routes.length];
        Set<Integer> visitedStop = new HashSet<>();

        for (int r: stopToRoutes.getOrDefault(source, Collections.emptyList())){
            queue.add(new int[]{r, 1});
            visitedRoute[r] =  true;
        }
        visitedStop.add(source);
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int route = cur[0], buses = cur[1];

            for (int stop : routes[route]) {
                if (stop == target) return buses;
                if (visitedStop.add(stop)) {
                    for (int nextRoute : stopToRoutes.getOrDefault(stop, Collections.emptyList())) {
                        if (!visitedRoute[nextRoute]) {
                            queue.add(new int[]{nextRoute, buses + 1});
                            visitedRoute[nextRoute] = true;
                        }
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        BusRoutes_815 b = new BusRoutes_815();
        b.numBusesToDestination(new int[][]{{1,2,7}, {3,6,7}}, 1, 6);
    }
}
