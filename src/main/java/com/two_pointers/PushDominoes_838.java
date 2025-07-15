package com.two_pointers;

public class PushDominoes_838 {
    public String pushDominoes(String dominoes) {
        String s = "L" + dominoes + "R";
        int left = 0;
        StringBuilder sb = new StringBuilder();

        for (int right = 1; right < s.length(); right++){
            if (s.charAt(right) == '.') continue;

            int span = right - left - 1;
            if (left > 0) sb.append(s.charAt(left));
            if (s.charAt(left) == s.charAt(right)){
                for (int i = 0; i < span; i++){
                    sb.append(s.charAt(left));
                }
            } else if (s.charAt(left) == 'L' && s.charAt(right) == 'R') {
                for (int i = 0; i < span; i++){
                    sb.append('.');
                }
            }else {
                for (int i = 0; i < span / 2; i++) sb.append('R');
                if (span % 2 == 1){
                    sb.append('.');
                }
                for (int i = 0; i < span / 2; i++) sb.append('L');
            }
            left = right;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        PushDominoes_838 p = new PushDominoes_838();
        //p.pushDominoes(".L.R...LR..L..");
        p.pushDominoes("RR.L");
    }
}
