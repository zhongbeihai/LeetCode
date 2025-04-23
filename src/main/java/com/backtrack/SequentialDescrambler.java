package com.backtrack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class SequentialDescrambler {
    HashMap<Integer, List<String>> wordLen = new HashMap<>();
    HashMap<String, Long> wordHash = new HashMap<>();
    List<List<String>> res = new ArrayList<>();
    Long wHash = 1L;
    int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
            31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
            73, 79, 83, 89, 97, 101};

    public void loadFile() {
        String filePath = "D:\\Program\\LeetCode\\src\\main\\resources\\google-10000-english-no-swears.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                char[] chars = line.toCharArray();
                long hash = 1L;
                // 使用 for-each 简化代码
                for (char c : chars) {
                    hash *= primes[c - 'a'];
                }
                wordHash.put(line, hash);

                // 使用 computeIfAbsent 简化代码
                wordLen.computeIfAbsent(line.length(), k -> new ArrayList<>()).add(line);
            }
        } catch (IOException e) {
            System.out.println("Failed to read file: " + filePath);
            e.printStackTrace();
        }
    }

    public boolean isValid(String w, List<String> tem){
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c: w.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (String s: tem){
            for (char c: s.toCharArray()){
                if (!map.containsKey(c)) return false;
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0){
                    map.remove(c);
                }
            }
        }

        return true;
    }

    public void backtrack(String w, int[] k, List<String> tem, int pos,
                          HashSet<String> used, long currentHash){
        if (pos == k.length){
            if (isValid(w, tem)) res.add(new ArrayList<>(tem));
            return;
        }

        int len = k[pos];
        List<String> candidates = wordLen.getOrDefault(len, Collections.emptyList());

        for (String candidate : candidates) {
            if (!used.contains(candidate)) {
                long candidateHash = wordHash.get(candidate);
                if (currentHash % candidateHash == 0) {
                    tem.add(candidate);
                    used.add(candidate);
                    backtrack(w, k, tem, pos + 1, used, currentHash / candidateHash);
                    tem.remove(tem.size() - 1);
                    used.remove(candidate);
                }
            }
        }
    }

    public List<List<String>> des(String w, int[] k){
        loadFile();
        for (char c : w.toCharArray()) {
            wHash *= primes[c - 'a'];
        }

        backtrack(w, k, new ArrayList<>(), 0, new HashSet<>(), wHash);

        return res;
    }

    public static void main(String[] args) {
        SequentialDescrambler s = new SequentialDescrambler();
        s.des("qeodwnsciseuesincereins", new int[]{4,7,12});
    }
}
