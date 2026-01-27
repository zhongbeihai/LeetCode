package com.hashtable;

import java.util.Arrays;
import java.util.HashSet;

public class ValidSudoku_36 {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length, m = board[0].length;
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++) {
                if (rows[i].contains(board[i][j])) return false;
                rows[i].add(board[i][j]);

                if (cols[j].contains(board[i][j])) return false;
                cols[j].add(board[i][j]);


                int idx = (i / 3) * 3 + (j / 3);
                if (boxes[idx].contains(board[i][j])) return false;
                boxes[idx].add(board[i][j]);
            }
        }

        return true;
    }
}
