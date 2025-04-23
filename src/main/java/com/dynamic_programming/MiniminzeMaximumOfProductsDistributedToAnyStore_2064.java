package com.dynamic_programming;

import java.util.*;
import java.util.stream.Collectors;

public class MiniminzeMaximumOfProductsDistributedToAnyStore_2064 {
    public int minimizedMaximum(int n, int[] quantities) {
        int lo = 1, hi = Arrays.stream(quantities).max().getAsInt();
        int ans = 0;
        while (lo <= hi){
            int mid = (lo + hi) / 2;
            if(canDistribute(n, quantities, mid)){
                ans = mid;
                hi = mid - 1;
            }else {
                lo = mid + 1;
            }
        }

        return ans;
    }

    public boolean canDistribute(int n, int[] q, int mid){
        int store = 0;
        for (int i : q){
            store += (int) Math.ceil((double)i / mid);
        }

        return store <= n;
    }

    public boolean hasEle(List<Integer> l, int target){
        return l.stream().anyMatch(ele -> ele < target);
    }

    public Optional<Integer> firstLess(List<Integer> l, int target){
        return l.stream().filter(ele -> ele < target).findFirst();
    }

    public static void main(String[] args) {
        MiniminzeMaximumOfProductsDistributedToAnyStore_2064 m = new MiniminzeMaximumOfProductsDistributedToAnyStore_2064();
        m.minimizedMaximum(22, new int[]{25,11,29,6,24,4,29,18,6,13,25,30});
    }
}
