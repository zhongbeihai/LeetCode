package com.two_pointers;

import java.util.Arrays;

public class BoatsToSavePeople_881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length - 1;
        int res = 0;
        while (left <= right){
            if (people[right] + people[left] <= limit){
                left++;
            }
            right--;
            res++;
        }
        return res;
    }
}
