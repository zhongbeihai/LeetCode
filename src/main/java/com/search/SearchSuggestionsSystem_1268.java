package com.search;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystem_1268 {
    class TrieNode{
        TrieNode[] children = new TrieNode[26]; // assume all letter are lowercase
        List<String> closeThree = new ArrayList<>();
    }

    class Trie{
        TrieNode root = new TrieNode();
        public void insert(String word){
            TrieNode worker = root;
            for (char c: word.toCharArray()){
                int idx = c - 'a';
                if (worker.children[idx] == null) worker.children[idx] = new TrieNode();
                worker = worker.children[idx];
                if (worker.closeThree.size() < 3) worker.closeThree.add(word);
            }
        }
        public List<String> find(String word){
            TrieNode worker = root;
            for (char c: word.toCharArray()){
                int idx = c - 'a';
                if (worker.children[idx] == null) return new ArrayList<>();
                worker = worker.children[idx];
            }
            return worker.closeThree;
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);

        Trie trie =new Trie();
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
