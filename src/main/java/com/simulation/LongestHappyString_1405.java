package com.simulation;

import structure.Pair;

import javax.print.DocFlavor;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class LongestHappyString_1405 {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair<Character, Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        if(a > 0)queue.add(new Pair<>('a', a));
        if(b > 0)queue.add(new Pair<>('b', b));
        if(c > 0)queue.add(new Pair<>('c', c));
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            Pair<Character, Integer> p = queue.poll();
            if(sb.length() == 0){
                int pv = p.getValue();
                int pp = pv;
                for (int i = pv; i > pv - 2 && i > 0; i--){
                    sb.append(p.getKey());
                    pp = i;
                }
                if(pp > 1) queue.add(new Pair<>(p.getKey(), pp- 1));
            } else if((p.getKey() == sb.charAt(sb.length() - 1) && !queue.isEmpty())){
                Pair<Character, Integer> p1 = queue.poll();
                sb.append(p1.getKey());
                queue.add(p);
                if(p1.getValue() > 1)queue.add(new Pair<>(p1.getKey(), p1.getValue() - 1));
            } else if (p.getKey() == sb.charAt(sb.length() - 1) && queue.isEmpty()) {
                break;
            } else {
                int pv = p.getValue();
                int pp = pv;
                for (int i = pv; i > pv - 2 && i > 0; i--){
                    sb.append(p.getKey());
                    pp = i;
                }
                if(pp > 1) queue.add(new Pair<>(p.getKey(), pp - 1));
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LongestHappyString_1405 l = new LongestHappyString_1405();
        l.longestDiverseString(4, 4, 3);
    }
}
