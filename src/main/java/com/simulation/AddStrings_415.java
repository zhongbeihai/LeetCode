package com.simulation;

public class AddStrings_415 {
    public String addStrings(String num1, String num2) {
        int p1 = num1.length() - 1, p2 = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while (p1 >= 0 && p2 >= 0){
            int cur = num1.charAt(p1) - '0' + num2.charAt(p2) - '0' + carry;
            sb.append(cur % 10);
            carry = cur / 10;
            p1--;
            p2--;
        }

        while (p1 >= 0){
            int cur = num1.charAt(p1) - '0' +carry;
            sb.append(cur % 10);
            carry = cur / 10;
            p1--;
        }

        while (p2 >= 0){
            int cur = num2.charAt(p2) - '0' + carry;
            sb.append(cur % 10);
            carry = cur / 10;
            p2--;
        }

        if (carry != 0) sb.append(carry);
        sb.reverse();

        return sb.toString();
    }
}
