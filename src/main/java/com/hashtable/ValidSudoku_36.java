package com.hashtable;

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

        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (board[i][j] == '.') continue;
                char c = board[i][j];
                // rows
                if (rows[i].contains(c)) return false;
                else rows[i].add(c);

                // cols
                if (cols[j].contains(c)) return false;
                else cols[j].add(c);

                // boxes
                int boxInd = (i / 3) * 3 + (j / 3);
                if (boxes[boxInd].contains(c)) return false;
                else boxes[boxInd].add(c);
            }
        }

        return true;
    }

}
