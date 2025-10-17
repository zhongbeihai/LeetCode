package com.search;

import javafx.util.Pair;

public class KthSmallestElementInASortedMatrix_378 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, N = n * n;
        int low = matrix[0][0], high = matrix[n - 1][n - 1];
        while (low < high){
            int mid = (low + high) >>> 1;
            if (countLE(matrix, mid) >= k){
                high = mid;
            }else {
                low = mid + 1;
            }
        }

        return low;
    }

    public int countLE(int[][] matrix, int mid){
        int n = matrix[0].length;
        int i = n - 1, j = 0, cnt = 0;
        while (i >= 0 && j < n){
            if (matrix[i][j] <= mid){
                cnt += i + 1;
                j++;
            }else {
                i--;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        KthSmallestElementInASortedMatrix_378 k = new KthSmallestElementInASortedMatrix_378();
        k.kthSmallest(new int[][]{{1,2},{1,3}}, 3);
    }
}
