package com.systemdesign;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;
import java.util.PriorityQueue;

public class FoodRatings {
    private HashMap<String, PriorityQueue<Pair<String, Integer>>> map = new HashMap<>();
    private HashMap<String, Integer> curStatus = new HashMap<>();
    private HashMap<String, String> foodToCusine = new HashMap<>();
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++){
            map.computeIfAbsent(cuisines[i], k -> new PriorityQueue<>((p, q) -> {
                int c = Integer.compare(q.getValue(), p.getValue());
                if (c != 0) return c;
                return p.getKey().compareTo(q.getKey());
            })).add(new Pair<>(foods[i], ratings[i]));
            curStatus.put(foods[i], ratings[i]);
            foodToCusine.put(foods[i], cuisines[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        if (!curStatus.containsKey(food)) return;
        curStatus.put(food, newRating);
        map.get(foodToCusine.get(food)).add(new Pair<>(food, newRating));
    }

    public String highestRated(String cuisine) {
        PriorityQueue<Pair<String, Integer>> pq = map.get(cuisine);
        while (!pq.isEmpty()){
            Pair<String , Integer> p = pq.peek();
            if (Objects.equals(p.getValue(), curStatus.get(p.getKey()))) {
                return p.getKey();
            }else {
                pq.poll();
            }
        }
        return "";
    }
}
