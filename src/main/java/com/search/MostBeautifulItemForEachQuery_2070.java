package com.search;

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;

import java.util.Arrays;
import java.util.TreeMap;

public class MostBeautifulItemForEachQuery_2070 {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        // <price, beauty>
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));
        int maxBeauty = 0;
        for(int[] item: items){
            maxBeauty = Math.max(item[1], maxBeauty);
            map.put(item[0], maxBeauty);
        }

        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            Integer key = map.floorKey(queries[i]);
            ans[i] = (key == null) ? 0 : map.get(key);
        }

        return ans;
    }

    public static void main(String[] args) {
        MostBeautifulItemForEachQuery_2070 m = new MostBeautifulItemForEachQuery_2070();
        m.maximumBeauty(new int[][]{{1,2},{3,2},{3,5}, {5,2}}, new int[]{1,2,3,4,5,6});
    }
}
