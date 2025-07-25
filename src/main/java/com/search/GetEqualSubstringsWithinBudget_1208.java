package com.search;

import java.util.PriorityQueue;

public class GetEqualSubstringsWithinBudget_1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();

        int left = 0, curCost = 0, maxLen = 0;
        for (int right = 0; right < ss.length; right++){
            curCost += Math.abs(ss[right] - tt[right]);

            while (curCost > maxCost){
                curCost -= Math.abs(ss[left] - tt[left]);
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }


    public static void main(String[] args) {
        GetEqualSubstringsWithinBudget_1208 g= new GetEqualSubstringsWithinBudget_1208();
        g.equalSubstring("krrgw", "zjxss", 19);
    }
}
