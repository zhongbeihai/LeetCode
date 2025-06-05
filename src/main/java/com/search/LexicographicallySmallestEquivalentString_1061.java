package com.search;

public class LexicographicallySmallestEquivalentString_1061 {
    int[] parent = new int[26];
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        for (int i = 0; i < 26; i++){
            parent[i] = i;
        }

        for (int i = 0; i < s1.length(); i++){
            char x = s1.charAt(i), y = s2.charAt(i);
            union(x, y);
        }

        StringBuilder sb = new StringBuilder();
        for (char c: baseStr.toCharArray()){
            sb.append((char)(find(c - 'a') + 'a'));
        }

        return sb.toString();
    }

    public void union(char x, char y){
        int rootX = find(x - 'a');
        int rootY = find(y - 'a');
        if (rootX == rootY) return;

        if (rootX < rootY) {
            parent[rootY] = rootX;
        }else  {
            parent[rootX] = parent[rootY];
        }
    }

    public int find(int x){
        if (parent[x] != x){
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    public boolean connected(int x, int y){
        return find(x) == find(y);
    }

    public static void main(String[] args) {
        LexicographicallySmallestEquivalentString_1061 l = new LexicographicallySmallestEquivalentString_1061();
        l.smallestEquivalentString("parker", "morris", "parser");
    }
}

