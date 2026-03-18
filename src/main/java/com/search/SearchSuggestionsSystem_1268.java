package com.search;


import structure.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystem_1268 {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        List<String> closestThree = new ArrayList<>();
    }

    class Trie{
        TrieNode root = new TrieNode();

        public void insert(String s){
            TrieNode worker = root;
            char[] ss = s.toCharArray();
            for(char c: ss){
                int idx = c - 'a';
                if (worker.children[idx] == null) worker.children[idx] = new TrieNode();
                worker = worker.children[idx];
                if (worker.closestThree.size() < 3) worker.closestThree.add(s);
            }
        }

        public List<String> get(String s){
            TrieNode worker = root;
            char[] ss = s.toCharArray();
            for (char c : ss){
                int idx = c - 'a';
                if (worker.children[idx] == null) return new ArrayList<>();
                worker = worker.children[idx];
            }
            return worker.closestThree;
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        Trie t = new Trie();
        for(String p: products) t.insert(p);

        List<List<String>> res = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        for (char c: searchWord.toCharArray()){
            s.append(c);
            res.add(t.get(s.toString()));
        }

        return res;
    }
}
