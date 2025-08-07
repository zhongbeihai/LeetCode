package com.simulation;

import java.util.ArrayDeque;
import java.util.Deque;

public class MovingAverageFromDataStream_346 {
    private Deque<Integer> deque;
    private int curSum;
    private int size;
    public MovingAverageFromDataStream_346(int size) {
        deque = new ArrayDeque<>();
        curSum = 0;
        this.size = size;
    }

    public double next(int val) {
        deque.addLast(val);
        curSum += val;
        while (deque.size() > this.size){
            curSum -= deque.pollFirst();
        }

        return (double) curSum / this.deque.size();
    }
}
