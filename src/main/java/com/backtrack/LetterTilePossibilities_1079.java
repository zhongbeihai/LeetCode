package com.backtrack;

import java.util.HashSet;

public class LetterTilePossibilities_1079 {
    private HashSet<String> set = new HashSet<>();

    public int numTilePossibilities(String tiles) {
        int[] frequencies = new int[26];
        for (char c : tiles.toCharArray()) {
            frequencies[c - 'A']++;
        }

        backtrack(frequencies, new StringBuilder(), 0, tiles.length());

        return set.size();
    }

    public void backtrack(int[] frequencies, StringBuilder sb, int pos, int len) {
        for (int i = pos; i < len; i++) {
            for (int j = 0; j < 26; j++) {
                if (frequencies[j] == 0) continue;

                sb.append((char)('A' + j));
                frequencies[j]--;
                set.add(sb.toString());

                backtrack(frequencies, sb, i + 1, len);

                sb.deleteCharAt(sb.length() - 1);
                frequencies[j]++;
            }
        }
    }

    public static void main(String[] args) {
        LetterTilePossibilities_1079 l = new LetterTilePossibilities_1079();
        l.numTilePossibilities("AAABBC");
    }
}

