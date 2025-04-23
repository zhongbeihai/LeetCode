package com.simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountDaysWithoutMeetings_3169 {
    public int countDays(int days, int[][] meetings) {
        List<int[]> m = new ArrayList<>();
        Arrays.sort(meetings, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }else {
                return a[0] - b[0];
            }
        });

        for (int[] meeting: meetings) {
            if (m.isEmpty()) {
                m.add(meeting);
                continue;
            } else {
                int ls = m.get(m.size() - 1)[0], le = m.get(m.size() - 1)[1];
                int cs = meeting[0], ce = meeting[1];
                if (cs > le) {
                    m.add(meeting);
                } else if (ce > le) {
                    m.remove(m.size() - 1);
                    m.add(new int[]{ls, ce});
                } else if (ce < le) {
                }
            }
        }

        int hasMeetings = 0;
        for (int[] hasm: m){
            hasMeetings += hasm[1] - hasm[0] + 1;
        }

        return days - hasMeetings;
    }
}

