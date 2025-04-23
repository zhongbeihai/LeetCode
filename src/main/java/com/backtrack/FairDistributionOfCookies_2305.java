package com.backtrack;

import javafx.util.Pair;

import java.util.Arrays;

public class FairDistributionOfCookies_2305 {
    public int distributeCookies(int[] cookies, int k) {
        int sum = 0;
        for (int cookie: cookies){
            sum += cookie;
        }
        Arrays.sort(cookies);

        int left = cookies[0], right = sum;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (distribute(cookies, new int[k], cookies.length - 1, mid)){
                right = mid ;
            }else {
                left = mid + 1;
            }

        }

        return left - 1;
    }

    public boolean distribute(int[] cookies, int[] bucket, int used, int mid){
        if (used == -1){
             return true;
        }

        for (int i = 0; i < bucket.length; i++){
            if (bucket[i] + cookies[used] >= mid ) continue;

            bucket[i] += cookies[used];

            if(distribute(cookies, bucket, used - 1, mid)) return true;

            bucket[i] -= cookies[used];
        }

        return false;
    }

    public static void main(String[] args) {
        FairDistributionOfCookies_2305 f = new FairDistributionOfCookies_2305();
        // f.distributeCookies(new int[]{8,15,10,20,8}, 2);
        f.distributeCookies(new int[]{13,3}, 2);
    }
}
