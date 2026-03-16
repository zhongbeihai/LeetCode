package com.hashtable;

import java.util.*;

public class FindAllPossibleRecipesFromGivenSupplies_2115 {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Set<String>> recToIng = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) recToIng.put(recipes[i], new HashSet<>(ingredients.get(i)));
        HashSet<String> suppliesSet = new HashSet<>(Arrays.asList(supplies));

        List<String> result = new ArrayList<>();
        HashMap<String, Integer> status = new HashMap<>(); // 1 -> can't make; 2 -> searching; 3-> can make it

        for (String rep: recipes){
            if (dfs(recToIng, suppliesSet, rep, status)) result.add(rep);
        }

        return result;
    }

    public boolean dfs(Map<String, Set<String>> recToIng, HashSet<String> suppliesSet,
                       String recipe, HashMap<String, Integer> status){
        // return condition
        if (suppliesSet.contains(recipe)) return true;
        if (!recToIng.containsKey(recipe)) return false;
        int s = status.getOrDefault(recipe, 0);
        if (s == 1 || s == 2) return false;
        if (s == 3) return true;

        status.put(recipe, 2);

        for (String ing: recToIng.get(recipe)){
            if (!dfs(recToIng, suppliesSet, ing, status)){
                status.put(ing, 1);
                return false;
            }
        }

        status.put(recipe, 3);
        suppliesSet.add(recipe);
        return true;
    }


}
