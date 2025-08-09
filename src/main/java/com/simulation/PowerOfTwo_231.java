package com.simulation;

import java.util.HashMap;
import java.util.Map;

public class PowerOfTwo_231 {
    public boolean isPowerOfTwo(int n) {
        if (n == 1 || n == 0) return true;
        else if ((n & 1) == 1 || n <= 0) {
            return false;
        }

        return isPowerOfTwo(n / 2) && isPowerOfTwo(n - n / 2);
    }

    public static void main(String[] args) {
        PowerOfTwo_231 p = new PowerOfTwo_231();
        boolean b = p.isPowerOfTwo(16);
        System.out.println(b);
    }
}
