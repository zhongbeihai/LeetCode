package com.simulation;

public class CountGoodNumbers_1922 {
    public int countGoodNumbers(long n) {
        int MOD = 1_000_000_007;
        if (n == 1) return 5;
        long odd = n / 2, even = (n + 1) / 2;


        return (int) (fastPow(5, even, MOD) * fastPow(4, odd, MOD) % MOD);
    }

    long fastPow(long base, long exp, long MOD) {
        long res = 1L;
        base %= MOD;

        while (exp > 0) {
            if ((exp & 1L) == 1L) {
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }


    public static void main(String[] args) {
        CountGoodNumbers_1922 c = new CountGoodNumbers_1922();
        c.countGoodNumbers(4);
    }
}
