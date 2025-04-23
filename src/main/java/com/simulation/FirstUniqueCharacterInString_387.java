package com.simulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FirstUniqueCharacterInString_387 {
    public int firstUniqChar(String s) {
        int[] letters = new int[26];

        char[] ss = s.toCharArray();
        for (char sc: ss){
            letters[sc -'a']++;
        }

        for (int i = 0; i < ss.length; i++){
            if (letters[ss[i] - 'a'] == 1) return i;
        }

        return -1;

    }
}
