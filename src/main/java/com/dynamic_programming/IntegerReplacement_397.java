package com.dynamic_programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntegerReplacement_397 {
    Map<Long, Integer> mem = new HashMap<>(); // number -> the num of operations to get it

    public int integerReplacement(int n) {
        mem.put(1L, 0);
        return dfs((long) n);
    }

    public int dfs(long n) {
        if (n == 1) return 0;
        if (mem.containsKey(n)) return mem.get(n);

        if (n % 2 == 0) {
            int even = 1 + dfs(n / 2);
            mem.put(n, even);
            return even;
        } else {
            int odd = 1 + Math.min(dfs(n + 1), dfs(n - 1));
            mem.put(n, odd);
            return odd;
        }
    }

    public static void main(String[] args) {
        IntegerReplacement_397 i = new IntegerReplacement_397();
        i.integerReplacement(8);
    }
}
