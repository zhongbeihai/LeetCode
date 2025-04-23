package com.simulation;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

import static java.util.concurrent.ForkJoinTask.invokeAll;

public class QuickSortComparison {
    // 生成随机数组
    public static int[] generateRandomArray(int size, int bound) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }

    // **1. 普通快速排序（单线程）**
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // **2. 并行快速排序（Fork/Join 实现）**
    static class ParallelQuickSort extends RecursiveAction {
        private final int[] arr;
        private final int left, right;

        ParallelQuickSort(int[] arr, int left, int right) {
            this.arr = arr;
            this.left = left;
            this.right = right;
        }

        @Override
        protected void compute() {
            if (left < right) {
                int pivot = partition(arr, left, right);
                ParallelQuickSort leftTask = new ParallelQuickSort(arr, left, pivot - 1);
                ParallelQuickSort rightTask = new ParallelQuickSort(arr, pivot + 1, right);
                invokeAll(leftTask, rightTask);
            }
        }
    }

    public static void main(String[] args) {
        final int SIZE = 100_000_000;
        final int BOUND = 100_000_000;

        // 生成相同的随机数组
        int[] arr1 = generateRandomArray(SIZE, BOUND);
        int[] arr2 = Arrays.copyOf(arr1, arr1.length);

        // **测试普通快速排序**
        long startTime = System.nanoTime();
        quickSort(arr1, 0, arr1.length - 1);
        long endTime = System.nanoTime();
        System.out.println("单线程快速排序耗时: " + (endTime - startTime) / 1e6 + " 毫秒");

        startTime = System.nanoTime();
        Arrays.parallelSort(arr1,0 , arr1.length - 1);
        endTime = System.nanoTime();
        System.out.println("多线程快速排序耗时: " + (endTime - startTime) / 1e6 + " 毫秒");
        // **测试并行快速排序**
        ForkJoinPool pool = new ForkJoinPool();
        startTime = System.nanoTime();
        pool.invoke(new ParallelQuickSort(arr2, 0, arr2.length - 1));
        endTime = System.nanoTime();
        System.out.println("并行快速排序耗时: " + (endTime - startTime) / 1e6 + " 毫秒");
    }
}
