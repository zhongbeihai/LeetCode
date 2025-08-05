package com.search;

import java.util.Arrays;

public class FruitIntoBasketII_3477 {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int unplaced = fruits.length;

        for (int fruit: fruits){
            for (int i = 0; i < baskets.length; i++){
                if (baskets[i] >= fruit) {
                    baskets[i] = -1;
                    unplaced--;
                    break;
                }
            }
        }
        return unplaced;
    }

    public int findIndex(int[] fruits, int baskets){
        int left = 0, right = fruits.length - 1, target = -1;

        while (left <= right){
            int mid = left + (right - left) / 2;
            if (fruits[mid] <= baskets){
                target = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return target;
    }

    public static void main(String[] args) {
        FruitIntoBasketII_3477 f = new FruitIntoBasketII_3477();
        f.numOfUnplacedFruits(new int[]{4,2,5}, new int[]{3,5,4});
    }
}
