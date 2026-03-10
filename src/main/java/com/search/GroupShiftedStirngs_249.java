package com.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStirngs_249 {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> stringToKey = new HashMap<>();
        for (String s: strings) {
            String k= getKeyOfString(s);
            stringToKey.computeIfAbsent(k, i -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(stringToKey.values());

    }

    public String getKeyOfString(String s){
        if (s.length() == 1) return "";

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            int diff = (s.charAt(i) - s.charAt(i - 1) + 26) % 26;
            sb.append(diff).append('#');
        }
        return sb.toString();
    }
}
