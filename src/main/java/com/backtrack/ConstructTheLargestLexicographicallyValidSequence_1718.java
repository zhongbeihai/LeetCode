package com.backtrack;

import java.util.Arrays;
import java.util.Queue;

public class ConstructTheLargestLexicographicallyValidSequence_1718 {
    private int[] res;
    public int[] constructDistancedSequence(int n) {
        res = new int[n * 2 - 1];
        int[] tem = new int[n * 2 - 1];
        tem[0]  = n;
        int[] lastPos = new int[n + 1];
        lastPos[n] = 1;
        int[] count = new int[n + 1];
        count[n] = 1;
        backtrack(n, 1, tem, lastPos,count);

        return res;
    }

    public boolean backtrack(int n, int pos, int[] tem, int[] lastPosition, int[] count){
        // stop condition
        if (tem[n * 2 - 2] != 0){
            if (compare(res, tem))res = Arrays.copyOf(tem, tem.length);
            return true;
        }

        for (int i = pos; i < n * 2 - 1; i++){
            for (int j = n; j >= 1; j--){
                int prePos = lastPosition[j];
                if (lastPosition[j] == 0 ||
                        (count[j] < 2 && lastPosition[j] != 0 && Math.abs(i - lastPosition[j]) + 1 == j)) {
                    if (j == 1 && lastPosition[1] != 0) continue;
                    tem[i] = j;
                    lastPosition[j] = i + 1;
                    count[j]++;
                    if(backtrack(n, i + 1, tem, lastPosition, count)) return true;
                    tem[i] = 0;
                    lastPosition[j] = prePos;
                    count[j]--;
                }
            }
            if (tem[i] == 0) return false;
        }
        return false;
    }

    // return true if s2 bigger than s1;
    public boolean compare(int[] s1, int[] s2){
        if (s1.length != s2.length) return false;

        for (int i = 0; i < s1.length; i++){
            if (s2[i] < s1[i]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        ConstructTheLargestLexicographicallyValidSequence_1718 c= new ConstructTheLargestLexicographicallyValidSequence_1718();
        c.constructDistancedSequence(5);
    }
}
