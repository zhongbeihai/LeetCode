package com.monotonic_stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class StockSpanner_901 {
    private LinkedList<Integer> priceTable;
    private LinkedList<Integer> spanTable;
    private int count;
    public StockSpanner_901() {
        priceTable = new LinkedList<>();
        spanTable = new LinkedList<>();
        count = 0;
    }

    public int next(int price) {
        priceTable.addLast(price);
        count++;
        getBiggest(price);
        return spanTable.getLast() ;
    }

    public void getBiggest(int price){
        Iterator<Integer> it = spanTable.iterator();
        int min = Integer.MAX_VALUE;
        while (it.hasNext()){
            if(priceTable.get(it.next()) < min && priceTable.get(it.next()) >= price ){
                min = it.next();
            }
        }
        if(min == Integer.MIN_VALUE){
            min = 1;
        }
        spanTable.addLast(min);
    }
}
