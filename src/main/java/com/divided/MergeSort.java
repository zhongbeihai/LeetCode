package com.divided;

public class MergeSort {
    public static void mergeSort(int[] arr){
        if(arr == null || arr.length <= 1) return;
        divide(arr, 0, arr.length - 1);
    }

    public static void divide(int[] arr, int start, int end){
        if (start >= end) return;

        int mid = start + (end - start) / 2;
        divide(arr, start, mid);
        divide(arr, mid + 1, end);

        merge(arr, start, mid, end);
    }

    public static void merge(int[] arr, int left, int mid, int right){
        int[] tem = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right){
            if (arr[i] <= arr[j]) {
                tem[k++] = arr[i++];
            } else {
                tem[k++] = arr[j++];
            }
        }
        while (i <= mid) tem[k++] = arr[i++];
        while (j <= right) tem[k++] = arr[j++];

        for (int p = left; p <= right; p++){
            arr[p] = tem[p - left];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{19,2,412,32,24,23,94,4};
        MergeSort.mergeSort(arr);
        for (int i: arr ){
            System.out.println(i + " ");
        }
    }
}
