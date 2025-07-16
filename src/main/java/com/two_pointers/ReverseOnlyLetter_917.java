package com.two_pointers;

public class ReverseOnlyLetter_917 {
    public String reverseOnlyLetters(String s) {
        char[] ss = s.toCharArray();
        char[] res = new char[ss.length];
        int left = 0, right = ss.length - 1;
        while (left <= right){
            char ll = ss[left];
            char rr = ss[right];
            boolean isLetter = Character.isLetter(ll);
            if ((Character.isLetter(ll) && Character.isLetter(rr)) ){
                res[left] = rr;
                res[right] = ll;
                left++;
                right--;
            } else if (!Character.isLetter(ll) && !Character.isLetter(rr)) {
                res[left] = ll;
                res[right] = rr;
                left++;
                right--;
            } else if (Character.isLetter(ll) && !Character.isLetter(rr)){
                res[right] = rr;
                right--;
            }else if (!Character.isLetter(ll) && Character.isLetter(rr)){
                res[left] = ll;
                left++;
            }
        }

        return String.valueOf(res);
    }

    public static void main(String[] args) {
        ReverseOnlyLetter_917 r = new ReverseOnlyLetter_917();
        r.reverseOnlyLetters("7_28]");
    }
}
