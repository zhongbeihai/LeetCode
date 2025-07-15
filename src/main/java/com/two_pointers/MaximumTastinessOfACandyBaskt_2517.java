package com.two_pointers;

import java.util.Arrays;

public class MaximumTastinessOfACandyBaskt_2517 {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int low = 0, high = price[price.length - 1] - price[0];
        while (low <= high){
            int mid = low + (high - low) / 2;
            if(check(price, k, mid)){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return high;
    }

    public boolean check(int[] price, int k, int re){
        int count = 1;
        int lastSelected = price[0];
        for(int i = 1; i < price.length; i++){

            if(Math.abs(price[i] - lastSelected) >= re) {
                count++;
                lastSelected = price[i];
                if(count == k) return true;
            }else {

            }
        }
        return false;
    }
}
