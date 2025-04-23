package com.simulation;


import java.util.regex.Pattern;

public class CrawlerLogFolder {
    public int minOperations(String[] logs) {
        int cnt = 0;
        java.util.regex.Pattern pattern = Pattern.compile("[a-zA-Z0-9]+/");
        for (String log : logs) {
            if (pattern.matcher(log).find()){
                cnt++;
            }
            if(log.equals("../") && cnt > 0) cnt--;
        }
        return cnt;
    }

    public static void main(String[] args) {
        CrawlerLogFolder c = new CrawlerLogFolder();
        c.minOperations(new String[]{"1d/","d2/","./","d3/","../","d31/"});
    }
}
