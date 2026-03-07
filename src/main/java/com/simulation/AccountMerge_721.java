package com.simulation;

import sun.reflect.generics.tree.Tree;

import java.awt.peer.FramePeer;
import java.util.*;

public class AccountMerge_721 {
    class UnionFind_721{
        HashMap<String, String> parent = new HashMap<>();
        HashMap<String, Integer> rank = new HashMap<>();

        public void add(String x){
            if (!parent.containsKey(x)){
                parent.put(x, x);
                rank.put(x, 1);
            }
        }

        public String find(String x){
            if (!parent.get(x).equals(x)) parent.put(x, find(parent.get(x)));
            return parent.get(x);
        }

        public void union(String p, String c){
            String rootp = find(p), rootc = find(c);

            if (rootc.equals(rootp)) return;

            int rankp = rank.get(rootp), rankc = rank.get(rootc);
            if (rankp < rankc){
                parent.put(rootp, rootc);
                rank.put(rootc, rankc + rankp);
            }else {
                parent.put(rootc, rootp);
                rank.put(rootp, rankc + rankp);
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind_721 u = new UnionFind_721();
        HashMap<String, String> map = new HashMap<>(); // email -> name

        for (List<String> acc: accounts){
            String name = acc.get(0);

            for (int i = 1; i < acc.size(); i++) {
                String email = acc.get(i);
                u.add(email);
                map.put(email, name);
            }

            String firstEmail =  acc.get(1);
            for (int i = 2; i < acc.size(); i++){
                u.union(firstEmail, acc.get(i));
            }
        }

        HashMap<String, TreeSet<String>> groups = new HashMap<>();
        for (String email: map.keySet()){
            String root = u.find(email);
            groups.computeIfAbsent(root, v -> new TreeSet<>()).add(email);
        }

        List<List<String>> res = new ArrayList<>();
        for (String key: groups.keySet()){
            String name = map.get(key);
            List<String> tem = new ArrayList<>();
            tem.add(name);
            tem.addAll(groups.get(key));

            res.add(tem);
        }

        return res;
    }
}
