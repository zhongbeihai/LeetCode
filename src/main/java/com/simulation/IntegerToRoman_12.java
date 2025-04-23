package com.simulation;

public class IntegerToRoman_12 {
    public String intToRoman(int num) {
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = new String[]{"M", "CM", "D",  "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length;i++){
            while (num >= values[i]){
                sb.append(symbols[i]);
                num -= values[i];
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman_12 i = new IntegerToRoman_12();
        i.intToRoman(3749);
    }
}
