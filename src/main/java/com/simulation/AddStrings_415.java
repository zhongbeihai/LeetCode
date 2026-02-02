package com.simulation;

public class AddStrings_415 {
    public String addStrings(String num1, String num2) {
        int p1 = num1.length() - 1, p2 = num2.length() - 1;

        int  r = 0;
        char[] nums1 = num1.toCharArray();
        char[] nums2 = num2.toCharArray();
        StringBuilder sb = new StringBuilder();
        while (p1 >= 0 && p2 >= 0){
            int n1 = nums1[p1] - '0', n2 = nums2[p2] - '0';
            sb.append((n1 + n2 + r) % 10);
            r = (n1 + n2 + r) / 10;

            p1--;
            p2--;
        }

        while (p1 >= 0){
            int n1 = nums1[p1] - '0';
            sb.append((n1 + r) % 10);
            r = (n1 + r) / 10;

            p1--;
        }

        while (p2 >= 0){
            int n2 = nums2[p2] - '0';
            sb.append((n2 + r) % 10);
            r = (n2 + r) / 10;

            p2--;
        }

        if (r != 0){
            sb.append(r);
        }

        return sb.reverse().toString();
    }
}
