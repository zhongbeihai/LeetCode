package com.simulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Snowflake1 {
    public static List<Integer> getMaxUpgradedServers(List<Integer> num_servers, List<Integer> money,
                                                      List<Integer> sell, List<Integer> upgrade) {
        // Write your code here
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < num_servers.size(); i++){
            int m = 0;
            for (int j = 0; j < num_servers.get(i); j++){
                int n = money.get(i) + j * sell.get(i) / upgrade.get(i);
                if (n <= num_servers.get(i) - j ) m = Math.max(m, n);
            }
            res.add(m);
        }

        return res;
    }

    public static List<String> findSchedules(int workHours, int dayHours, String pattern) {
        List<String> schedules = new ArrayList<>();
        int n = pattern.length();
        int fixedHours = 0;
        StringBuilder fixed = new StringBuilder();
        List<Integer> questionMarks = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char c = pattern.charAt(i);
            if (c == '?') {
                questionMarks.add(i);
            } else {
                fixed.append(c);
                fixedHours += c - '0';
            }
        }

        int remainingHours = workHours - fixedHours;
        int questionCount = questionMarks.size();
        generateSchedules(schedules, new StringBuilder(pattern), questionMarks, 0, remainingHours, dayHours);

        Collections.sort(schedules);
        return schedules;
    }

    private static void generateSchedules(List<String> schedules, StringBuilder current, List<Integer> questionMarks,
                                          int index, int remainingHours, int dayHours) {
        if (index == questionMarks.size()) {
            if (remainingHours == 0) {
                schedules.add(current.toString());
            }
            return;
        }

        int pos = questionMarks.get(index);
        for (int h = 0; h <= dayHours; h++) {
            current.setCharAt(pos, (char) ('0' + h));
            int newRemaining = remainingHours - h;
            if (newRemaining >= 0) {
                generateSchedules(schedules, current, questionMarks, index + 1, newRemaining, dayHours);
            }
        }
        current.setCharAt(pos, '?');
    }
}
