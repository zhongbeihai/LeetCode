package com.hashtable;

import java.util.*;

public class SnapshotArray {
    int snapTime = 0;
    // <snap_id, val>
    ArrayList<Map<Integer, Integer>> list;
    public SnapshotArray(int length) {
        list = new ArrayList<>(Collections.nCopies(length+2, null));
        for(int i = 0; i < length; i++){
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(snapTime, 0);
            list.set(i, map);
        }
        snapTime++;
    }

    public void set(int index, int val) {
//        if(list.get(index) == null){
//            HashMap<Integer, Integer> map = new HashMap<>();
//            map.put(snapTime, val);
//            list.set(snapTime, map);
//        }else {
//            Set<Integer> keySet = list.get(index).keySet();
//            TreeSet<Integer> sortedSet = new TreeSet<>(Comparator.reverseOrder());
//            sortedSet.addAll(keySet);
//            if(sortedSet.contains(snapTime)){
//                list.get(index).put(snapTime, val);
//            }else {
//                list.get(sortedSet.first()).put(snapTime, val);
//            }
//        }
        list.get(index).put(snapTime, val);
    }

    public int snap() {
        snapTime++;
        return snapTime - 1;
    }

    public int get(int index, int snap_id) {
        if(list.get(index) == null) return 0;
        Map<Integer, Integer> index_map = list.get(index);
        TreeSet<Integer> sortedSet = new TreeSet<>(Comparator.reverseOrder());
        sortedSet.addAll(index_map.keySet());
        if(sortedSet.isEmpty())return 0;
        if(sortedSet.contains(snap_id)){
            return index_map.get(snap_id);
        }else {
            return index_map.get(sortedSet.higher(snap_id));
        }
    }

    public static void main(String[] args) {
        SnapshotArray s = new SnapshotArray(3);
        s.get(1,6);
        s.snap();
        s.snap();
        s.set(1,19);
        s.set(0,4);
        s.get(2, 1);
        s.get(2, 0);
        s.get(0, 1);
    }
}
