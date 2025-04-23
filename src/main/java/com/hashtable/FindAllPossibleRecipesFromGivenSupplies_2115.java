package com.hashtable;

import java.util.*;

public class FindAllPossibleRecipesFromGivenSupplies_2115 {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        // < ingredients, List<recipes>>
        HashMap<String, List<String>> unlockMap = new HashMap<>();
        // <recipes, number of ingredients needed>
        HashMap<String, Integer> needCount = new HashMap<>();

        for (int i = 0; i < recipes.length; i++){
            needCount.put(recipes[i], ingredients.get(i).size());
            for (String ingredient: ingredients.get(i)){
                unlockMap.putIfAbsent(ingredient, new ArrayList<>());
                unlockMap.get(ingredient).add(recipes[i]);
            }
        }

        List<String> res = new ArrayList<>();
        HashSet<String> visited = new HashSet<>(Arrays.asList(supplies));
        Queue<String> queue = new ArrayDeque<>(Arrays.asList(supplies));

        while (!queue.isEmpty()){
            String ing = queue.poll();
            visited.add(ing);

            List<String> recis = unlockMap.get(ing);
            if (recis == null) continue;
            for (String re: recis){
                needCount.put(re, needCount.get(re) - 1);
                if (needCount.get(re) == 0){
                    needCount.remove(re);
                    res.add(re);
                    if (!visited.contains(re)) {
                        visited.add(re);
                        queue.add(re);
                    }
                }
            }
        }
        return res;
    }
}
