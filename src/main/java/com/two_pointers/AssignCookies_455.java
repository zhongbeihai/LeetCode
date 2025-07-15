package com.two_pointers;

import java.util.Arrays;

public class AssignCookies_455 {
    public int findContentChildren(int[] g, int[] s) {
        int gp = 0, sp = 0, res = 0;
        Arrays.sort(s);
        Arrays.sort(g);
        while (sp < s.length && gp < g.length){
            if(s[sp] >= g[gp]) {
                res++;
                gp++;
            }
            sp++;
        }

        return res;
    }
}
