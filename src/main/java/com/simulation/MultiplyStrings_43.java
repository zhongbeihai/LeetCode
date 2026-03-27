package com.simulation;

public class MultiplyStrings_43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        char[] num1Arr = num1.toCharArray(), num2Arr = num2.toCharArray();
        int n = num1.length(), m = num2.length();

        int[] res = new int[n + m];
        for (int i = n - 1; i >= 0; i--){
            int n1 = num1Arr[i] - '0';
            for (int j = m - 1; j >= 0; j--){
                int n2 = num2Arr[j] - '0';

                int sum = res[i + j + 1] + n1 * n2;
                res[i + j + 1] = sum % 10;
                res[i + j] += sum /10;
            }
        }

        StringBuilder sb = new StringBuilder();
        int k = 0;
        while (k < res.length && res[k] == 0) k++;
        while (k < res.length) sb.append(res[k++]);

        return sb.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings_43 m = new MultiplyStrings_43();
        m.multiply("123", "456");
    }
}
