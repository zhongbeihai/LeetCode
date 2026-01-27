package com.search;

public class MedianOfTwoSortedArrays_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Aleft <= Bright
        // Aright >= BLeft

        if (nums1.length > nums2.length){
            int[] tem = nums1;
            nums1 = nums2;
            nums2 = tem;
        }

        int m = nums1.length, n = nums2.length;
        int k = (m + n + 1) / 2;

        int low = 0, high = m;
        while (low <= high){
            int i = low + (high - low) / 2;
            int j = k - i;

            int Aleft = nums1[i] == 0? Integer.MIN_VALUE : nums1[i - 1];
            int Aright = nums1[i] == m? Integer.MAX_VALUE : nums1[i];
            int Bleft = nums2[j] == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            int Bright = nums2[j] == n ? Integer.MAX_VALUE: nums2[j];

            if (Aleft <= Bright && Aright >= Bleft){
                if ((m + n) % 2 == 1) return Math.max(Aleft, Bleft);
                else {
                    int leftMax = Math.max(Aleft, Bleft);
                    int rightMin = Math.min(Aright, Bright);
                    return (leftMax + rightMin) / 2.0;
                }
            } else if (Aleft > Bright) {
                high = i - 1;
            }else {
                low = i + 1;
            }
        }

        return 0.0;
    }
}
