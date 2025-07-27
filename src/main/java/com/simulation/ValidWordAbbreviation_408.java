package com.simulation;

public class ValidWordAbbreviation_408 {
    public boolean validWordAbbreviation(String word, String abbr) {
        char[] words = word.toCharArray();
        char[] abbrs = abbr.toCharArray();

        //if (Character.isDigit(abbrs[0])) return false;
        int p = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < abbrs.length; i++){
            if (Character.isDigit(abbrs[i])){
                sb.append(abbrs[i]);
            } else if (Character.isLetter(abbrs[i])) {
                if (sb.length() != 0){
                    if (sb.charAt(0) == '0') return false;
                    int step = Integer.valueOf(sb.toString());
                    p += step;
                    sb.replace(0, sb.length(),"");
                }
                if (p >= words.length || abbrs[i] != words[p]) return false;
                p++;
            }
        }

        if (sb.length() != 0){
            if (sb.charAt(0) == '0') return false;
            int step = Integer.valueOf(sb.toString());
            p += step;

        }
        return p == words.length;

    }

    public static void main(String[] args) {
        ValidWordAbbreviation_408 v = new ValidWordAbbreviation_408();
        // v.validWordAbbreviation("internationalization", "i12iz4");
        v.validWordAbbreviation("ab", "a");
    }
}
