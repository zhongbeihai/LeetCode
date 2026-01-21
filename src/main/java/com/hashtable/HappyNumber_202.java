package com.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Input: n = 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * The question hint that the numbers maybe occur more than once. So to statistic the frequency of
 * element -> hashtable
 */
public class HappyNumber_202 {
    Map<Integer, Integer> map = new HashMap<>();
    public boolean isHappy(int n) {
        if (n == 1) return true;
        if (map.containsKey(n)) return false;
        return isHappy(cal(n));
    }

    public int cal(int n){
        if (map.containsKey(n)) return map.get(n);

        char[] cn = String.valueOf(n).toCharArray();
        int cnt = 0;
        for (char c: cn){
            cnt += (c - '0') * (c - '0');
        }

        map.put(n, cnt);

        return cnt;
    }

    public static void main(String[] args) {
        HappyNumber_202 h = new HappyNumber_202();
        h.isHappy(2);
    }
}
