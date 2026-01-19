package com.simulation;

import java.util.*;

public class InvalidTransactions_1169 {
    public List<String> invalidTransactions(String[] transactions) {
        Map<String, List<String>> mapByName = new HashMap<>();

        for (String tran: transactions){
            String[] data = tran.split(",");
            mapByName.computeIfAbsent(data[0], v -> new ArrayList<>()).add(tran);
        }

        List<String> res = new ArrayList<>();
        for (List<String> trans: mapByName.values()){
            Set<Integer> invalid = new HashSet<>(); // store index of invalid trans
            for (int i = 0; i < trans.size(); i++) {
                for (int j = 0; j < trans.size(); j++) {

                    String[] t1 = trans.get(i).split(","), t2 = trans.get(j).split(",");
                    Integer time1 = Integer.parseInt(t1[1]), time2 = Integer.parseInt(t2[1]);
                    if (Math.abs(time2 - time1) <= 60 && !t1[3].equals(t2[3]) ) {
                        invalid.add(i);
                        invalid.add(j);
                    }
                    if (Integer.parseInt(t1[2]) > 1000) invalid.add(i);
                    if (Integer.parseInt(t2[2]) > 1000) invalid.add(j);
                }
            }

            for (int i: invalid){
                res.add(trans.get(i));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        InvalidTransactions_1169 i = new InvalidTransactions_1169();
        String[] inva = new String[]{"alice,20,800,mtv","bob,50,1200,mtv"};
        i.invalidTransactions(inva);
    }
}
