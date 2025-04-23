package com.dynamic_programming;

public class WildcardMatching_44 {
    public boolean isMatch(String s, String p) {
        char[] pp = p.toCharArray();
        char[] ss = s.toCharArray();
        if (s.isEmpty() && pp[0] == '*') return true;
        int p1 = 0, s1 = 0, n = s.length(), m = p.length();
        while (s1 < n && p1 < m){
            if (pp[p1] == '*'){
                if (p1 == pp.length - 1) return true;
                p1++;
                s1++;
                while (s1 < n && pp[p1] != ss[s1]){
                    s1++;
                }
            }else if (pp[p1] == '?'){

            }else {
                if (ss[s1] != pp[p1]) return false;
            }

            p1++;
            s1++;
        }
        return (p1 != m || s1 == n) && (p1 == m || s1 != n || pp[pp.length - 1] == '*');
    }

    public static void main(String[] args) {
        WildcardMatching_44 w = new WildcardMatching_44();
        // w.isMatch("adceb", "*a*b");
        w.isMatch("abcabczzzde","*abc???de*");
    }
}
