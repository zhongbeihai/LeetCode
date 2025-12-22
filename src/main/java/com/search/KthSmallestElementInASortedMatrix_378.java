package com.search;


public class KthSmallestElementInASortedMatrix_378 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0], high = matrix[n - 1][n - 1];

        while (low < high){
            int mid = low + (high - low) / 2;
            if (count(matrix, mid) >= k){
                high = mid;
            }else {
                low = mid + 1;
            }
        }

        return low;
    }

    public int count(int[][] matrix, int mid){
        int n = matrix.length;
        int count = 0;
        int row = 0, col = n - 1;

        while (row < n && col >= 0){
            if (matrix[row][col] <= mid){
                count += col + 1;
                row++;
            }else {
                col--;
            }
        }

        return count;
    }



    public static void main(String[] args) {
        KthSmallestElementInASortedMatrix_378 k = new KthSmallestElementInASortedMatrix_378();
        k.kthSmallest(new int[][]{{1,5,9},{10,11,13},{12,13,15}}, 3);
    }
}
