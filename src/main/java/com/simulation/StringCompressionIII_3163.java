package com.simulation;

public class StringCompressionIII_3163 {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        int f = 0, r = 0;
        while (r < word.length()){

            if(r + 1 < word.length() && word.charAt(r + 1) == word.charAt(r) && r - f  + 1< 9 ){
                r++;
            }else{
                sb.append(r - f + 1).append(word.charAt(r));
                r++;
                f = r;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        StringCompressionIII_3163 s = new StringCompressionIII_3163();
        s.compressedString("aaaaaaaaaaaaaabb");
    }
}
