package com.simulation;

import java.util.ArrayList;
import java.util.List;

public class NumberOfLaserBeamsInBank_2125 {
    public int numberOfBeams(String[] bank) {
        List<Integer> sd = new ArrayList<>();
        for (String b : bank){
            int c = 0;
            for (int i = 0; i < b.length(); i++) {
                if (b.charAt(i) == '1') c++;
            }
            if (c != 0) sd.add(c);
        }

        if (sd.size() < 2) return 0;
        int res = 0;
        for (int i = 1; i < sd.size(); i++){
            res += sd.get(i) * sd.get(i - 1);

        }

        return res;
    }
}
