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
    public boolean isHappy(int n) {
        // <number, frequency>
        Map<Integer, Integer> map = new HashMap<>();

        int qq = n;
        while(true){
            int pp = getSum(qq);
            if(pp == 1) return true;
            if(map.containsKey(pp) && map.get(pp) > 1) return false;
            map.put(pp, map.getOrDefault(pp, 0) + 1);
            qq = pp;
        }
    }

    public int getSum(int n){
        int sum = 0;
        while(n != 0){
            sum += (n % 10) * (n % 10);
            n /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        HappyNumber_202 h = new HappyNumber_202();
        h.isHappy(2);
    }
}
