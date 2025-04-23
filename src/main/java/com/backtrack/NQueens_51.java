package com.backtrack;

import java.util.ArrayList;
import java.util.List;

public class NQueens_51 {
    private List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        List<String> board = new ArrayList<>();
        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++){
                sb.append(".");
            }
            board.add(sb.toString());
        }
        backTracking(n, board, 0);
        return res;
    }

    public void backTracking(int n, List<String> board, int row){
        if(row == board.size()){
            res.add(new ArrayList<>(board));
            return;
        }

        for(int col = 0; col < n; col++){
            if(!isValid(board, row, col)){
                continue;
            }

            StringBuilder sb = new StringBuilder(board.get(row));
            sb.setCharAt(col, 'Q');
            board.set(row, sb.toString());

            backTracking(n, board, row + 1);

            sb.setCharAt(col, '.');
            board.set(row, sb.toString());
        }
    }

    boolean isValid(List<String> board, int row, int col) {
        int n = board.size();

        /* 检查列是否有皇后互相冲突 */
        for (int i = 0; i < n; i++) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }

        /* 检查右上方是否有皇后互相冲突 */
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        /* 检查左上方是否有皇后互相冲突 */
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        return true;
    }
}
