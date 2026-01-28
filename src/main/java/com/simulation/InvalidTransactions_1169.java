package com.simulation;

import java.util.*;

public class InvalidTransactions_1169 {
    public List<String> invalidTransactions(String[] transactions) {
        Map<String, List<String>> nameToTransaction = new HashMap<>();
        for (String t: transactions){
            String[] data = t.split(",");
            nameToTransaction.computeIfAbsent(data[0], v -> new ArrayList<>()).add(t);
        }

        List<String> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> e: nameToTransaction.entrySet()){
            Set<Integer> invalidTrans = new HashSet<>();
            List<String > trans = e.getValue();
            for (int i = 0; i < trans.size(); i++){
                String[] t1 = trans.get(i).split(",");

                for (int j = 0; j < trans.size(); j++){
                    String[] t2 = trans.get(j).split(",");
                    if (Math.abs(Integer.parseInt(t1[1]) - Integer.parseInt(t2[1])) <= 60 && !t1[3].equals(t2[3]) ){
                        invalidTrans.add(i);
                        invalidTrans.add(j);
                    }
                    if (Integer.parseInt(t1[2]) > 1000) invalidTrans.add(i);
                    if (Integer.parseInt(t2[2]) > 1000) invalidTrans.add(j);
                }
            }
            for (int i: invalidTrans) res.add(trans.get(i));
        }

        return res;
    }

    public static void main(String[] args) {
        InvalidTransactions_1169 i = new InvalidTransactions_1169();
        String[] inva = new String[]{"alice,20,1220,mtv","alice,20,1220,mtv"};
        i.invalidTransactions(inva);
    }
}
