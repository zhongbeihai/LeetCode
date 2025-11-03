package com.simulation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GoatLatin_824 {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A','E','I','O','U'));
        String MA = "ma";
        for (int i = 0; i < words.length; i++){
            if (vowels.contains(words[i].charAt(0))){
                sb.append(words[i]);
                sb.append(MA);
            }else {
                sb.append(words[i].substring(1));
                sb.append(words[i].charAt(0)).append(MA);
            }

            for (int j = 0; j < i + 1; j++) sb.append('a');

            if (i < words.length - 1) sb.append(' ');
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        GoatLatin_824 g = new GoatLatin_824();
        g.toGoatLatin("I speak Goat Latin");
    }
}
