package com.hashtable;

import java.util.*;

public class FindAllPossibleRecipesFromGivenSupplies_2115 {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String, List<String>> recToIng = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) recToIng.put(recipes[i], ingredients.get(i));
        HashSet<String> suppliesSet = new HashSet<>(Arrays.asList(supplies));

        Map<String, Integer> status = new HashMap<>(); // 1 -> searching, 2 -> can't make , 3 -> can make
        List<String> res = new ArrayList<>();
        for (String rec:recipes){
            if (dfs(recToIng, suppliesSet, rec, status)) res.add(rec);
        }

        return res;
    }

    public boolean dfs(HashMap<String, List<String>> recToIng, HashSet<String> suppliesSet, String rec, Map<String, Integer> status){
        // return condition
        if (suppliesSet.contains(rec)) return true;
        if (!recToIng.containsKey(rec)) return false;
        int s = status.getOrDefault(rec, 0);
        if (s == 1 || s == 2) return false;
        if (s == 3) return true;

        status.put(rec, 1);
        List<String> ings = recToIng.get(rec);
        for (String i: ings){
            if (!dfs(recToIng, suppliesSet, i, status)){
                status.put(i, 2);
                return false;
            }
        }

        status.put(rec, 3);
        suppliesSet.add(rec);
        return true;
    }


}
