package com.hashtable;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings_205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!sToT.containsKey(s.charAt(i))){
                sToT.put(s.charAt(i), t.charAt(i));
            }else {
                if (sToT.get(s.charAt(i)) != t.charAt(i)) return false;
            }

            if (!tToS.containsKey(t.charAt(i))){
                tToS.put(t.charAt(i), s.charAt(i));
            }else {
                if (tToS.get(t.charAt(i)) != s.charAt(i)) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings_205 i = new IsomorphicStrings_205();
        i.isIsomorphic("egg", "add");
    }
}
