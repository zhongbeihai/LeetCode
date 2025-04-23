package com.doublepointers;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Arrays;

/**
 * Given a string s and an integer k,
 * reverse the first k characters for every 2k characters counting from the start of the string.
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 */
public class ReverseStringII_541 {
    public String reverseStr(String s, int k) {
        char[] nums = s.toCharArray();
        int h = 0, r;
        if(k > nums.length){
            r = nums.length - 1;
        }else {
            r = k - 1;
        }

        while(h < r) {
            int i = h;
            int j = r;
            while (i < j) {

                char tem = nums[i];
                nums[i] = nums[j];
                nums[j] = tem;
                i++;
                j--;
            }
            h = plus(nums, k, h);
            r = plus(nums, k, r);
        }
        StringBuffer stringBuffer = new StringBuffer();
        for(char a : nums){
            stringBuffer.append(a);
        }
        System.out.println(stringBuffer.toString());
        return stringBuffer.toString();
    }

    public int plus(char[] nums, int k, int r){
        if((r + 2 * k) > nums.length){
            r = nums.length - 1;
        }else {
            r = r + 2 * k;
        }
        return r;
    }

    public static void main(String[] args) {
        ReverseStringII_541 r = new ReverseStringII_541();
        r.reverseStr("abcdefg",2);
    }
}
