package com.simulation;

import java.util.Arrays;

public class HIndex_274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int cnt = 0;
        for(int i = citations.length - 1; i >= 0; i--){
            if(citations[i] > cnt) cnt++;
            if(citations[i] == cnt) return cnt;
        }
        return cnt;
    }

    public static void main(String[] args) {
        HIndex_274 h = new HIndex_274();
        h.hIndex(new int[]{3,0,6,1,5});
    }
}
