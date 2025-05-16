package com.simulation;

import java.util.Arrays;

public class PlusOne_66 {
    public int[] plusOne(int[] digits) {
        recursion(digits, digits.length - 1);

        if (digits[0] == 0){
            int[] n = new int[digits.length + 1];
            n[0] = 1;
            for (int i = 1; i < digits.length; i++){
                n[i] = digits[i - 1];
            }
            return n;
        }
        return digits;
    }

    public void recursion(int[] digits, int pos){
        digits[pos] = (digits[pos] + 1) % 10;
        if (digits[pos] == 0 && pos != 0) recursion(digits, pos - 1);
    }

    public static void main(String[] args) {
        PlusOne_66 p = new PlusOne_66();
        p.plusOne(new int[]{99, 99});
    }
}
