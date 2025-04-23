package com.search;

public class SearchA2DMatrix_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int[] firstEachRow = new int[m];

        for (int i = 0; i < m; i++) {
            firstEachRow[i] = matrix[i][0];
        }

        // Binary search to find the correct row
        int l = 0, r = m - 1, row = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (firstEachRow[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        row = r; // The correct row should be at `r`, not `l`

        // Edge case: If row is negative, target is smaller than the smallest element
        if (row < 0) return false;

        int[] col = matrix[row];

        // Binary search in the selected row
        l = 0;
        r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (col[mid] == target) {
                return true;
            } else if (col[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        SearchA2DMatrix_74 s = new SearchA2DMatrix_74();
        //s.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 13);
        s.searchMatrix(new int[][]{{1}}, 1);
    }
}
