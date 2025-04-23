package com.simulation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MinimumIndexOfAValidSplit_2780 {
    public int minimumIndex(List<Integer> nums) {
        HashMap<Integer, Integer> fres = new HashMap<>();
        for (int i : nums){
            fres.put(i, fres.getOrDefault(i, 0) + 1);
        }

        int e = nums.get(0);
        for (int i: fres.keySet()){
            if (fres.get(i) > fres.get(e)) e = i;
        }

        int ec = 0;
        for (int i = 0; i < nums.size(); i++){
            if (nums.get(i) == e) {
                ec++;
                if (ec * 2 > i + 1 && (fres.get(e) - ec) * 2 > nums.size() - i - 1) return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        MinimumIndexOfAValidSplit_2780 m = new MinimumIndexOfAValidSplit_2780();
        m.minimumIndex(Arrays.asList(1,2,2,2));
    }
}
