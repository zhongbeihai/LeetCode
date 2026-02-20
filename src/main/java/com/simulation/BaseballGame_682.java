package com.simulation;

import java.util.ArrayList;

public class BaseballGame_682 {
    public int calPoints(String[] operations) {
        ArrayList<Integer> list = new ArrayList<>();

        int scores = 0;
        for (String  o: operations){
            if (o.equals("C")){
                scores -= list.get(list.size() - 1);
                list.remove(list.size() - 1);
                continue;
            }
            int n = 0;
            if (o.equals("+")){
                n = list.get(list.size() - 1) + list.get(list.size() - 2);
            }else if (o.equals("D")){
                n = list.get(list.size() - 1) * 2;
            } else  {
                n = Integer.parseInt(o);
            }
            list.add(n);
            scores += n;
        }

        return scores;
    }
}
