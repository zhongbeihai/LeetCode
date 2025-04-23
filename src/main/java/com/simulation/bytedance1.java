package com.simulation;

import java.util.Arrays;
import java.util.List;

public class bytedance1 {
    public static int getPlaylistCount(List<Integer> videoLengths, int k, int threshold) {
        // Write your code here
        int n = videoLengths.size();
        int left = 0, res = 0, count = 0;
        for(int right = 0; right < n; right++){
            if(videoLengths.get(right) <= threshold) count++;

            if(right - left + 1 == k){
                if (count == k) {
                    res++;
                }
                if (videoLengths.get(left) <= threshold) {
                    count--;
                }
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        Integer[] arr = new Integer[]{6,10,34,24,12,21,30,35};
        bytedance1.getPlaylistCount(Arrays.asList(arr), 2, 30);
    }
}
