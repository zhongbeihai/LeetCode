package com.divided;

public class MergeSort {
    public static void mergeSort(int[] arr){
        if(arr == null || arr.length <= 1) return;
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int left, int right){
        // stop condition
        if (left >= right) return;
        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right){
        int[] tem = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right){
            if (arr[i] <= arr[j]){
                tem[k++] = arr[i++];
            }else {
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
        MergeSort.mergeSort(new int[]{19,2,412,32,24,23,94,4});
    }
}
