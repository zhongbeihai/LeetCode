package com.divided;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void quickSort(int[] arr, int s, int e){
        if (s >= e) return;

        int pivot = arr[s];  // 保存首元素的值 (坑)
        int i = s, j = e;     // i 和 j 分别指向首尾

        while (i < j) {
            // 从右向左找到第一个小于 pivot 的元素
            while (i < j && arr[j] >= pivot) j--;
            if (i < j) arr[i++] = arr[j];  // 将小于 pivot 的元素移到左边坑里

            // 从左向右找到第一个大于 pivot 的元素
            while (i < j && arr[i] <= pivot) i++;
            if (i < j) arr[j--] = arr[i];  // 将大于 pivot 的元素移到右边坑里
        }

        arr[i] = pivot;  // 最后将 pivot 放入最终位置

        // 递归处理左右子数组
        quickSort(arr, s, i - 1);
        quickSort(arr, i + 1, e);

    }

    public static void swap(int[] arr, int i , int j){
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }

    public static int[] generateRandomArray(int length, int min, int max) {
        if (length < 0) {
            throw new IllegalArgumentException("Length must be non-negative");
        }
        if (min > max) {
            throw new IllegalArgumentException("Min value must be less than or equal to max value");
        }

        Random random = new Random();
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            // nextInt(bound) 生成 [0, bound) 的随机数
            // 我们将其转换为 [min, max] 范围
            result[i] = random.nextInt(max - min + 1) + min;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] randomArray1 = generateRandomArray(50000, 0, 3000);
        QuickSort.quickSort(randomArray1, 0, randomArray1.length - 1);
        System.out.println(randomArray1.toString());
    }
}
