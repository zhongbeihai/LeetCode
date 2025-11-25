package com.simulation;

public class RotateImage_48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // vertical exchange: exchange matrix[i] and matrix[j]
        int left = 0, right = n - 1;
        while (left < right){
            int[] tem = matrix[left];
            matrix[left] = matrix[right];
            matrix[right] = tem;
            left++;
            right--;
        }
        // transpose: exchange matrix[i][j] and matrix[j][i]
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tem = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tem;
            }
        }
    }

    public static void main(String[] args) {
        RotateImage_48 r = new RotateImage_48();
        r.rotate(new int[][]{{1,2,3}, {4,5,6},{7,8,9}});
    }
}
