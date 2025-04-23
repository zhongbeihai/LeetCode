package com.simulation;

public class RotateString_796 {
    public boolean rotateString(String s, String goal) {
        for(int i = 1; i <= s.length(); i++){
            String left = s.substring(0, i);
            String right = s.substring(i, s.length());

            if(goal.equals(right + left)) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        RotateString_796 r = new RotateString_796();
        r.rotateString("abcde", "cdeab");
    }
}
