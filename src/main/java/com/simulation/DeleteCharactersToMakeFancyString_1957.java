package com.simulation;

import com.sun.corba.se.impl.orb.ParserTable;

import java.util.Stack;

public class DeleteCharactersToMakeFancyString_1957 {
    public String makeFancyString(String s) {
        int count = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        for(int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                sb.append(s.charAt(i));
                count = 1;
            } else if (s.charAt(i) == s.charAt(i - 1) && count < 2) {
                sb.append(s.charAt(i));
                count++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DeleteCharactersToMakeFancyString_1957 d = new DeleteCharactersToMakeFancyString_1957();
        d.makeFancyString("aaabaaaa");
    }
}
