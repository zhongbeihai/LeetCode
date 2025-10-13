package com.search;

public class Search2DMatrixII_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++){
            int[] col = matrix[i];
            int idx = binarySearch(col, target);
            if (idx != n && matrix[i][idx] == target) return true;
        }

        return false;
    }

    /**
     *
     * @param nums
     * @param target
     * @return find the index i that nums[i] is the first number bigger than target
     */
    public int binarySearch(int[] nums, int target){
        int left = 0, right = nums.length;

        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target){
                right = mid;
            }else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        Search2DMatrixII_240 s = new Search2DMatrixII_240();
        s.searchMatrix(new int[][]{{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}}, 5);
    }
}
