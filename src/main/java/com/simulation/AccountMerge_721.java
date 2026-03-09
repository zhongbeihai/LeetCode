package com.simulation;

import sun.reflect.generics.tree.Tree;

import java.awt.peer.FramePeer;
import java.util.*;

public class AccountMerge_721 {
    class UnionFind_721 {
        Map<String, String> parent = new HashMap<>();
        Map<String, Integer> rank = new HashMap<>();

        public void add(String x) {
            parent.put(x, x);
            rank.put(x, 1);
        }

        public String find(String x) {
            if (!parent.get(x).equals(x)) parent.put(x, find(parent.get(x)));
            return parent.get(x);
        }

        public void connect(String x, String y) {
            String rootX = find(x), rootY = find(y);
            if (rootY.equals(rootX)) return;

            int rankX = rank.get(x), rankY = rank.get(y);
            if (rankX < rankY) {
                parent.put(rootX, rootY);
                rank.put(rootY, rankX + rankY);
            } else {
                parent.put(rootY, rootX);
                rank.put(rootX, rankX + rankY);
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        UnionFind_721 u = new UnionFind_721();
        for (List<String> acc : accounts) {
            String name = acc.get(0);
            for (int i = 1; i < acc.size(); i++) {
                u.add(acc.get(i));
                emailToName.put(acc.get(i), name);
            }
            String firstEmail = acc.get(1);
            for (int i = 2; i < acc.size(); i++) u.connect(firstEmail, acc.get(i));
        }

        Map<String, TreeSet<String>> parentToChildren = new HashMap<>();
        for (String email : emailToName.keySet()) {
            String root = u.find(email);
            parentToChildren.computeIfAbsent(root, v -> new TreeSet<>()).add(email);
        }

        List<List<String>> res = new ArrayList<>();
        for (String k : parentToChildren.keySet()) {
            List<String> tem = new ArrayList<>();
            tem.add(emailToName.get(k));
            tem.addAll(parentToChildren.get(k));
            res.add(tem);
        }

        return res;
    }

}
