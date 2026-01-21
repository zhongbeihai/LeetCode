package com.simulation;

import java.util.Arrays;

public class PlusOne_66 {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        int carry = digits[n - 1] + 1 == 10 ? 1 : 0;
        digits[n - 1] = (digits[n - 1] + 1) % 10;
        for (int i = n - 2; i >= 0; i--){
            int d = (digits[i] + carry) % 10;
            carry = digits[i] + carry == 10 ? 1 : 0;
            digits[i] = d;
        }

        if (digits[0] == 0 && carry == 1){
            int[] res = new int[n + 1];
            res[0] = 1;
            System.arraycopy(digits, 0, res, 1, n - 1);
            return res;
        }else {
            return digits;
        }
    }


    public static void main(String[] args) {
        PlusOne_66 p = new PlusOne_66();
        p.plusOne(new int[]{8,9});
    }
}
