package com.simulation;

public class ReverseWordsInString_151 {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        for (char c: s.toCharArray()){
            if (c == ' ' && sb.charAt(sb.length() - 1) == ' ') continue;
            sb.append(c);
        }

        sb.reverse();
        char[] ss = sb.toString().toCharArray();
        int i = 0, start = 0;
        while (i < ss.length){
            if (ss[i] ==' ') {
                i++;
                continue;
            }
            // find the end of this word -> to find the space
            int j = i;
            while (j < ss.length - 1 && ss[j+1] != ' ') j++;
            start = j + 1;
            while (i < j){
                char tem = ss[i];
                ss[i] = ss[j];
                ss[j] = tem;
                i++;
                j--;
            }
            i = start;
        }

        return String.valueOf(ss);
    }

    public static void main(String[] args) {
        ReverseWordsInString_151 r = new ReverseWordsInString_151();
        r.reverseWords("a good   example  ");
    }
}
