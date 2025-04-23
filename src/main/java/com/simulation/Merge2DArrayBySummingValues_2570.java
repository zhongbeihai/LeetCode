package com.simulation;

import java.util.ArrayList;
import java.util.List;

public class Merge2DArrayBySummingValues_2570 {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> list = new ArrayList<>();
        int p1 = 0; // point to nums1
        int p2 = 0; // point to nums2;
        int n = nums1.length, m = nums2.length;
        while (p1 < n && p2 < m){
            if (nums1[p1][0] == nums2[p2][0]){
                list.add(new int[]{nums1[p1][0], nums1[p1][1] + nums2[p2][1]});
                p1++;
                p2++;
            }else if (nums1[p1][0] < nums2[p2][0]){
                list.add(new int[]{nums1[p1][0], nums1[p1][1]});
                p1++;
            }else if (nums1[p1][0] > nums2[p2][0]){
                list.add(new int[]{nums2[p2][0], nums2[p2][1]});
                p2++;
            }
        }

        while (p1 < n){
            list.add(new int[]{nums1[p1][0], nums1[p1][1]});
            p1++;
        }
        while (p2 < m){
            list.add(new int[]{nums2[p2][0], nums2[p2][1]});
            p2++;
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }

        return res;
    }
}
