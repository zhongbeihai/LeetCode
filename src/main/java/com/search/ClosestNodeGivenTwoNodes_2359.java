package com.search;

import java.util.*;

public class ClosestNodeGivenTwoNodes_2359 {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        List<Integer> node1Path = new ArrayList<>();
        List<Integer> node2Path = new ArrayList<>();

        dfs(edges, node1, node1Path);
        dfs(edges, node2, node2Path);

        if (equalList(node1Path, node2Path)){
            Collections.sort(node1Path);
            return node1Path.get(0);
        }
        return findFirstCommonElement(node1Path, node2Path);
    }

    public boolean equalList(List<Integer> list1, List<Integer> list2 ){
        if (list1.size() != list2.size()) return false;
        Set<Integer> set = new HashSet<>(list1);

        return set.containsAll(list2);
    }

    public <T> T findFirstCommonElement(List<T> list1, List<T> list2) {
        Set<T> set2 = new HashSet<>(list2); // 用于快速查找 list2 中的元素
        for (T item : list1) {
            if (set2.contains(item)) {
                return item; // 找到第一个同时存在于两个列表的元素
            }
        }
        return null; // 如果没有找到相同元素，返回 null
    }

    public void dfs(int[] edges, int node, List<Integer> res){
        if (res.contains(node)) return ;

        res.add(node);
        if (edges[node] == -1) return;
        dfs(edges, edges[node], res);
    }

    public static void main(String[] args) {
        ClosestNodeGivenTwoNodes_2359 c = new ClosestNodeGivenTwoNodes_2359();
        c.closestMeetingNode(new int[]{1,2, -1}, 0, 2);
    }
}
