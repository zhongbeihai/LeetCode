package com.binary_tree;

import java.util.Arrays;
import java.util.HashSet;

public class FindUniqueBinaryString_1980 {
    HashSet<String> set = new HashSet<>();
    String res;
    public String findDifferentBinaryString(String[] nums) {
        set.addAll(Arrays.asList(nums));

        backtrack(nums[0].length(), new StringBuilder());

        return res;
    }

    public boolean backtrack(int len, StringBuilder sb){
        // stop condition
        if (sb.length() == len){
            if (!set.contains(sb.toString())) {
                res = sb.toString();
                return true;
            }
            return false;
        }

        for (int i = 0; i < 2; i++){
            sb.append(i);

            if (backtrack(len, sb)) return true;

            sb.deleteCharAt(sb.length() - 1);
        }

        return false;
    }

    public static void main(String[] args){
        FindUniqueBinaryString_1980 f = new FindUniqueBinaryString_1980();
        f.findDifferentBinaryString(new String[]{"01","10"});
    }
}
