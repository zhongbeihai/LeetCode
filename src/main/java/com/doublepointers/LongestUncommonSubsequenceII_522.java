package com.doublepointers;

public class LongestUncommonSubsequenceII_522 {
    private boolean isSubsequence(String s1, String s2){
        if (s1.length() > s2.length()) return false;
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()){
            if (s1.charAt(i) == s2.charAt(j)) i++;
            j++;
        }
        return i == s1.length();
    }

    public int findLUSlength(String[] strs) {
        int ans = -1;
        for (int i = 0; i < strs.length; i++){
            if (strs[i].length() < ans) continue;
            boolean isUncommon = true;
            for (int j = 0 ; j < strs.length; j++){
                if (j != i && isSubsequence(strs[i], strs[j])){
                    isUncommon =false;
                    break;
                }
            }
            if (isUncommon) ans =Math.max(ans, strs[i].length());
        }

        return ans;
    }

    public static void main(String[] args) {
        LongestUncommonSubsequenceII_522 l = new LongestUncommonSubsequenceII_522();
        l.findLUSlength(new String[]{"aaa","aaa","aa"});
    }
}
