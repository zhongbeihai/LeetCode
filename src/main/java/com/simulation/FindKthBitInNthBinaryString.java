package com.simulation;

public class FindKthBitInNthBinaryString {
    public char findKthBit(int n, int k) {
        StringBuilder last = new StringBuilder("0");
        for(int i = 1; i < n; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(last).append("1").append(invert(last.toString()));
            last = sb;
        }
        return last.toString().charAt(k - 1);
    }

    public String invert(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                sb.append('1');
            }else {
                sb.append('0');
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        FindKthBitInNthBinaryString f = new FindKthBitInNthBinaryString();
        f.findKthBit(4, 11);
    }
}
