package com.hashtable;

import java.util.*;

public class RandomizedSet {
    List<Integer> list = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    int cnt = 0;
    Random rand = new Random();

    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if (set.contains(val)) return false;
        set.add(val);
        list.add(val);
        cnt++;
        return true;
    }

    public boolean remove(int val) {
        if (!set.contains(val)) return false;
        set.remove(val);
        list.remove(new Integer(val));
        cnt--;
        return true;
    }

    public int getRandom() {
        int r = rand.nextInt() % cnt;
        return list.get(r);
    }
}
