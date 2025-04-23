package com.dequeue_and_priorityqueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class MergeSortedSum_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, p = m + n - 1;
        while(p1 >= 0 && p2 >= 0) {
            nums1[p] = nums1[p1] >= nums2[p2] ? nums1[p1--] : nums2[p2--];
            p--;
        }
        while(p2 >= 0){
            nums1[p--] = nums2[p2--];
        }
    }


    public static void main(String[] args) {
        MergeSortedSum_88 m = new MergeSortedSum_88();
        m.merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
    }
}
