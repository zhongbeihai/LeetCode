package com.two_pointers;

public class Largest3SameDigitNumberInString_2264 {
    public String largestGoodInteger(String num) {
        char[] numArr = num.toCharArray();
        if (numArr.length < 3) return "";

        int resStart = -1;
        for (int i = 0; i < numArr.length - 2; i++){
            if (numArr[i] == numArr[i + 1]  && numArr[i + 1] == numArr[i + 2]) {
                if (resStart == -1 || numArr[i]  > numArr[resStart]) resStart = i;
            }
        }

        return resStart == -1 ? "" : num.substring(resStart, resStart + 3);
    }

    public static void main(String[] args) {
        Largest3SameDigitNumberInString_2264 l = new Largest3SameDigitNumberInString_2264();
        l.largestGoodInteger("222");
    }
}
