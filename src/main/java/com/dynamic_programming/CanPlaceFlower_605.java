package com.dynamic_programming;

public class CanPlaceFlower_605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0 ) return true;

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) continue;
            if (i != flowerbed.length - 1 && flowerbed[i + 1] == 1) continue;
            if (i != 0 && flowerbed[i - 1] == 1) continue;

            n--;
            flowerbed[i] = 1;
            if(n == 0) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        CanPlaceFlower_605 c = new CanPlaceFlower_605();
        c.canPlaceFlowers(new int[]{0,0,1,0,1}, 1);
    }
}
