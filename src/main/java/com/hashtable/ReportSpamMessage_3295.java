package com.hashtable;

import java.util.Arrays;
import java.util.HashSet;

public class ReportSpamMessage_3295 {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        HashSet<String> set = new HashSet<>(Arrays.asList(bannedWords));

        int cnt = 0;
        for (String m: message){
            if (set.contains(m)) cnt++;
            if (cnt == 2) return true;
        }

        return false;
    }
}
