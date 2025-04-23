package com.simulation;

public class Pow_50 {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (x == 1.0) return x;
        if (x == -1.0) {
            if (n % 2 == 0) return 1;
            else return -1;
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        if (n < -2147483600) return 0;
        double res = x;
        for (int i = 1; i < n; i++){
            res *= x;
            if (x < 0.000000001) return 0;
        }

        return res;
    }

    public static void main(String[] args) {
        Pow_50 p = new Pow_50();
        p.myPow(2.00000, -2147483648);
    }
}
