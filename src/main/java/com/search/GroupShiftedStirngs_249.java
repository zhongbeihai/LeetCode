package com.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStirngs_249 {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s: strings){
            String key = getKeyOfString(s);
            map.computeIfAbsent(key, i -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public String getKeyOfString(String s){
        if (s.length() == 1) return "1#1";

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            int gap = s.charAt(i) - s.charAt(i - 1);
            if (gap < 0) gap += 26;
            gap %= 26;
            sb.append(gap).append("#");
        }

        return sb.toString();
    }
}
