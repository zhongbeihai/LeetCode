package com.doublepointers;

public class RotatingTheBox_1861 {
    public char[][] rotateTheBox(char[][] box) {
        char[][] res = new char[box[0].length][box.length];

        for (char[] row : box) {
            int r = row.length - 1, l = r;
            while (l - 1 >= 0) {
                while (row[l] == '.') {
                    l--;
                }
                if (row[l] == '#') {
                    row[l] = '.';
                    row[r] = '#';
                } else if (row[l] == '*') {
                    l--;
                }
                while (r > l && row[r] != '.') r--;
                while (l - 1 >= 0 && row[l] != '.') l--;

            }
        }

        for(int i = 0; i < box.length; i++){
            for(int j = 0; j < box[0].length; j++){
                res[j][box.length - i - 1] = box[i][j];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        RotatingTheBox_1861 r = new RotatingTheBox_1861();
//        r.rotateTheBox(new char[][]{{'#', '.','*','.'},
//                {'#','#','*','.'}, {'.','#','*','.'}});
        r.rotateTheBox(new char[][]{{'#','#','*','.','*','.'},
              {'#','#','#','*','.','.'},
              {'#','#','#','.','#','.'}});
    }
}
