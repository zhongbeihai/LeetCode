package com.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class RandomizedSet {
    private final HashSet<Integer> set;
    private final Random rand;
    public RandomizedSet() {
        this.set = new HashSet<>();
        this.rand = new Random();
    }

    public boolean insert(int val) {
        return this.set.add(val);
    }

    public boolean remove(int val) {
        return this.set.remove(val);
    }

    public int getRandom() {
        Integer[] array = set.toArray(new Integer[0]);
        return array[rand.nextInt(array.length)];
    }
}
