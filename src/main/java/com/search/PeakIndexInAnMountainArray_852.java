package com.search;

public class PeakIndexInAnMountainArray_852 {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length, l = 0, r = n - 1;

        while (l < r){
            int mid = l + (r - l) / 2;
            if (arr[mid] > arr[mid + 1]){
                r = mid;
            }else {
                l = mid + 1;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        PeakIndexInAnMountainArray_852 p = new PeakIndexInAnMountainArray_852();
        p.peakIndexInMountainArray(new int[]{0,1,0});
    }
}
