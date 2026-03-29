package com.search;


import structure.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystem_1268 {
    class Node{
        Node[] children = new Node[26];
        List<String> minStrings = new ArrayList<>();
    }

    class Trie{
        Node root = new Node();
        public void insert(String s){
            Node worker = root;
            for (char c: s.toCharArray()){
                int idx = c - 'a';
                if (worker.children[idx] == null) worker.children[idx] = new Node();
                worker = worker.children[idx];
                if (worker.minStrings.size() < 3) worker.minStrings.add(s);
            }
        }

        public List<String> search(String s){
            Node worker = root;
            for (char c: s.toCharArray()){
                int idx = c - 'a';
                if (worker.children[idx] == null) return new ArrayList<>();
                worker = worker.children[idx];
            }
            return worker.minStrings;
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        Trie t = new Trie();
        for (String p: products) t.insert(p);

        List<List<String>> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char c: searchWord.toCharArray()){
            sb.append(c);
            res.add(t.search(sb.toString()));
        }

        return res;
    }
}
