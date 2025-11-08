package com.simulation;

import java.util.ArrayList;
import java.util.List;

public class KidsWithGreatestNumberOfCandies_1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candy: candies){
            max = Math.max(max, candy);
        }

        List<Boolean> b = new ArrayList<>();
        for (int candy : candies) {
            if (candy + extraCandies >= max) b.add(true);
            else b.add(false);
        }

        return b;
    }
}
