package com.search;

import sun.swing.StringUIClientPropertyKey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystem_1268 {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        List<String> closeThree = new ArrayList<>();
    }

    class Trie{
        private TrieNode root = new TrieNode();
        public void insert(String word){
            TrieNode node = root;
            for (char c: word.toCharArray()){
                int idx = c - 'a';
                if (node.children[idx] == null) node.children[idx] = new TrieNode();

                node = node.children[idx];

                if (node.closeThree.size() < 3) node.closeThree.add(word);
            }
        }
        public List<String> find(String word){
            TrieNode node = root;

            List<String> res = new ArrayList<>();
            for (char c: word.toCharArray()){
                int idx = c - 'a';
                if (node.children[idx] == null) return new ArrayList<>();
                node = node.children[idx];
            }

            return node.closeThree;
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);

        Trie trie = new Trie();
        for (String p: products) trie.insert(p);

        List<List<String>> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < searchWord.length(); i++) {
            sb.append(searchWord.charAt(i));
            res.add(trie.find(sb.toString()));
        }
        return res;
    }
}
