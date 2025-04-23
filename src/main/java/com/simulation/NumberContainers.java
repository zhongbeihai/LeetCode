package com.simulation;

import java.util.*;

public class NumberContainers {
    private HashMap<Integer, TreeSet<Integer>> numToIdx;
    private HashMap<Integer, Integer> idxToNum;
    public NumberContainers() {
        this.numToIdx = new HashMap<>();
        this.idxToNum = new HashMap<>();
    }

    public void change(int index, int number) {
        // purge previous number
        if (this.idxToNum.get(index) != null){
            int preNum = this.idxToNum.get(index);
            this.numToIdx.get(preNum).remove(index);
            if (this.numToIdx.get(preNum).isEmpty()) numToIdx.remove(preNum);
        }

        // update
        this.idxToNum.put(index, number);
        if (this.numToIdx.get(number) != null){
            this.numToIdx.get(number).add(index);
        }else {
            TreeSet<Integer> lhs = new TreeSet<>();
            lhs.add(index);
            this.numToIdx.put(number, lhs);
        }
    }

    public int find(int number) {
        if (this.numToIdx.get(number) != null){
            return this.numToIdx.get(number).first();
        }else {
            return -1;
        }
    }
}
