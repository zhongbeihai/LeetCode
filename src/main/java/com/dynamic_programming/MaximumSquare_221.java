package com.dynamic_programming;

public class MaximumSquare_221 {
    private Integer[][] memo;
    public int maximalSquare(char[][] matrix) {
        memo = new Integer[matrix.length][matrix[0].length];

        int max = 0;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == '1') {
                    int a = dfs(matrix, i, j);
                    max = Math.max(max, a);
                }else {
                    memo[i][j] = 0;
                }
            }
        }

        return max * max;
    }

    public int dfs(char[][] matrix, int r, int c){
        if(memo[r][c] != null) return memo[r][c];
        if (r == matrix.length - 1 || c == matrix[0].length - 1){
            memo[r][c] = matrix[r][c] == '1' ? 1 : 0;
            return memo[r][c];
        }
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {1, 1}};
        int res = 1;
        int min = Integer.MAX_VALUE;
        for(int[] dir : directions){
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr < matrix.length && nc < matrix[0].length) {
                if (matrix[nr][nc] == '1') {
                    min = Math.min(min, dfs(matrix, nr, nc));
                } else {
                    min = 0;
                }
            }

        }
        memo[r][c] = 1 + min;
        return memo[r][c];
    }

    public static void main(String[] args) {
        MaximumSquare_221 m = new MaximumSquare_221();
//        m.maximalSquare(new char[][]{{'1','0','1','0','0'}, {'1','0','1','1','1'},
//                {'1','1','1','1','1'}, {'1','0','0','1','0'}});
        m.maximalSquare(new char[][]{{'1'}});
    }
}
