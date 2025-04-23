package com.dequeue_and_priorityqueue;

public class FindLongestSubstringThatOccursThriceI_2981 {
    private String s;
    public int maximumLength(String s) {
        this.s = s;
        int l = 0, r = s.length() - 1;

        while (l < r){
            int mid = (l + r) / 2;
            if(check(mid)){
                l = mid;
            }else {
                r = mid - 1;
            }
        }

        return l == 0 ? -1 : l;
    }

    public boolean check(int k){
        int[] cnt = new int[26];
        int j = 0;
        for(int i = 0; i < s.length();){
            j = i + 1;
            while (j < s.length() && s.charAt(j) == s.charAt(i)){
                j++;
            }
            int c = s.charAt(i) - 'a';
            cnt[c] += Math.max(0, j - i - k + 1);
            if(cnt[c] >= 3) return true;
            i = j;
        }
        return false;
    }
}
