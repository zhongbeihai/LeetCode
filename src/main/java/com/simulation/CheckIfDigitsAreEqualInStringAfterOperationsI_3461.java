package com.simulation;

public class CheckIfDigitsAreEqualInStringAfterOperationsI_3461 {
    public boolean hasSameDigits(String s) {
        char[] a = s.toCharArray();

        for (int i = a.length - 2; i >= 1; i--) {
            for (int j = 0; j <= i; j++){
                a[j] = (char) ((a[j] - '0' + a[j + 1] - '0' ) % 10 + '0');
            }
        }

        return a[0] == a[1];
    }

    public static void main(String[] args) {
        CheckIfDigitsAreEqualInStringAfterOperationsI_3461 c= new CheckIfDigitsAreEqualInStringAfterOperationsI_3461();
        c.hasSameDigits("3902");
    }
}
