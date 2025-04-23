package com.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class ShoppingOffers_638 {
    int res = Integer.MAX_VALUE;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        backTrack(price, special, needs, 0, 0);

        return res;
    }

    public void backTrack(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int min, int pos){
        int totalPrice = 0;
        for (int i = 0; i < needs.size(); i++){
            totalPrice += price.get(i) * needs.get(i);
        }
        res = Math.min(res, min + totalPrice);

        for (int i = pos; i < special.size(); i++){
            boolean validOffer = true;
            List<Integer> thisOffer = special.get(i);
            for (int j = 0; j < needs.size(); j++){
                if (needs.get(j) < thisOffer.get(j)) {
                    validOffer = false;
                    break;
                }
            }

            if (validOffer){
                List<Integer> dummy = new ArrayList<>(needs);
                for (int j = 0; j < needs.size(); j++){
                    dummy.set(j, dummy.get(j) - thisOffer.get(j));
                }

                backTrack(price, special, dummy, min + thisOffer.get(thisOffer.size() - 1), i);
            }
        }
    }
}
