package com.binary_tree;

public class SumOfPrefixScoresOfStrings_2416 {
    private class DicTreeNode{
        int cnt;
        DicTreeNode[] child;

        private DicTreeNode(){
            cnt = 0;
            child = new DicTreeNode[26];
        }
        private DicTreeNode(int cnt){
            this.cnt = cnt;
            this.child = new DicTreeNode[26];
        }
    }
    public int[] sumPrefixScores(String[] words) {
        DicTreeNode root = new DicTreeNode();
        for(String word : words){
            insert(root, word);
        }
        int[] ans = new int[words.length];
        for(int i = 0; i < words.length; i++){
            ans[i] = query(root, words[i]);
        }

        return ans;
    }

    public void insert(DicTreeNode root, String str){
        DicTreeNode cur = root;
        for(char ch : str.toCharArray()){
            if(cur.child[ch - 'a'] == null) cur.child[ch - 'a'] = new DicTreeNode(0);
            cur = cur.child[ch - 'a'];
            cur.cnt++;
        }
    }

    public int query(DicTreeNode root, String word){
        DicTreeNode cur = root;
        int ans = 0;
        for(char ch : word.toCharArray()){
            cur = cur.child[ch - 'a'];
            ans += cur.cnt;
        }
        return ans;
    }

    public static void main(String[] args) {
        SumOfPrefixScoresOfStrings_2416 s = new SumOfPrefixScoresOfStrings_2416();
        s.sumPrefixScores(new String[]{"abc","ab","bc","b"});
    }
}
