package com.dequeue_and_priorityqueue;

import sun.util.resources.cldr.zh.CalendarData_zh_Hans_SG;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber_17 {
    ArrayList<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        HashMap<Integer, List<Character>> phoneKeyPad = new HashMap<>();
        phoneKeyPad.put(2, Arrays.asList('a', 'b', 'c'));
        phoneKeyPad.put(3, Arrays.asList('d', 'e', 'f'));
        phoneKeyPad.put(4, Arrays.asList('g', 'h', 'i'));
        phoneKeyPad.put(5, Arrays.asList('j', 'k', 'l'));
        phoneKeyPad.put(6, Arrays.asList('m', 'n', 'o'));
        phoneKeyPad.put(7, Arrays.asList('p', 'q', 'r', 's'));
        phoneKeyPad.put(8, Arrays.asList('t', 'u', 'v'));
        phoneKeyPad.put(9, Arrays.asList('w', 'x', 'y', 'z'));
        dfs(phoneKeyPad, digits, 0, "");
        return res;
    }

    public void dfs(HashMap<Integer, List<Character>> map, String digits, int n, String path){
        int dl = digits.length();
        if(dl == n) {
            res.add(path);
            return;
        }

        List<Character> curList =  map.get(Integer.parseInt(String.valueOf(digits.charAt(n))));
        for(int i = 0; i < curList.size(); i++){
            String ori = path;
            path += curList.get(i);
            dfs(map, digits, n + 1, path);
            path = ori;
        }

    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber_17 l = new LetterCombinationsOfAPhoneNumber_17();
        l.letterCombinations("23");
    }
}
