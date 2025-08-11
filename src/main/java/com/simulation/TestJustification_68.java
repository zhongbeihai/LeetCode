package com.simulation;

import java.util.ArrayList;
import java.util.List;

public class TestJustification_68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        List<String> res = new ArrayList<>();

        int usedWord = 0;
        while (usedWord < n){
            int curLineLen = 0, numOfWord = 0;
            while (usedWord + numOfWord < n && curLineLen + words[usedWord + numOfWord].length() < maxWidth){
                curLineLen += words[usedWord + numOfWord].length();
                numOfWord++;
            }

            if (numOfWord == 1){
                StringBuilder sb = new StringBuilder();
                sb.append(words[usedWord]);
                for (int i = 0; i < maxWidth - words[usedWord].length(); i++) sb.append(" ");
                res.add(sb.toString());
                usedWord += 1;
                continue;
            }

            int firstSlot = (maxWidth - curLineLen) % (numOfWord - 1);
            StringBuilder sb = new StringBuilder();
            sb.append(words[usedWord]);

            if (numOfWord > 2){
                int restSlot = (maxWidth - firstSlot) / (numOfWord - 2);
                for (int i = 0; i < firstSlot; i++) sb.append(" ");
                for (int i = 1; i < numOfWord; i++){
                    sb.append(words[usedWord + i]);
                    for (int j = 0; j < restSlot; j++) sb.append(" ");
                }
            }


            usedWord += numOfWord;
            res.add(sb.toString());
        }

        // format last line
        String lastLine = res.get(res.size() - 1);
        String[] lastLines = lastLine.split(" ");
        StringBuilder newLastLine = new StringBuilder();
        for (int i = 0; i < lastLines.length - 1; i++){
            newLastLine.append(lastLines[i]);
            newLastLine.append(" ");
        }
        newLastLine.append(lastLines[lastLines.length - 1]);
        res.remove(res.size() - 1);
        res.add(newLastLine.toString());

        return res;
    }

    public static void main(String[] args) {
        TestJustification_68 t = new TestJustification_68();
        t.fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16);
    }
}
