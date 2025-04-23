package com.backtrack;

import java.util.HashSet;

public class FIndThePunishmentNumberOfAnInteger_2698 {
    public int punishmentNumber(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++){
            int s = i * i;
            if (backTracking(i, Integer.toString(s), 0, 0, Integer.toString(s).length())) res += s;
        }

        return res;
    }

    public boolean backTracking(int p, String n, int pos, int curSum,int digit){
        // stop condition
        if (curSum == p && pos == digit){
            return true;
        }
        if (pos == digit) return false;

        for (int i = pos; i < digit; i++){
            int subSum = Integer.parseInt(n.substring(pos,i + 1));
            curSum += subSum;

            boolean f = backTracking(p, n, i + 1, curSum, digit);
            if (f) return true;
            curSum -= subSum;
        }

        return false;
    }

    public static void main(String[] args) {
        FIndThePunishmentNumberOfAnInteger_2698 f= new FIndThePunishmentNumberOfAnInteger_2698();
        f.punishmentNumber(10);
    }
}
