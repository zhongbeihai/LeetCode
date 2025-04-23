package com.simulation;

public class DefuseTheBomb_1652 {
    public int[] decrypt(int[] code, int k) {
        int[] res = new int[code.length];
        if(code.length <= 1) return res;
        int left = 1, right = k, count = 0, sum = 0, len = 0;
        if(k < 0){
            left = code.length - Math.abs(k);
            right =code.length - 1;
        }

        for(int i = left; i <= right; i++){
            sum += code[i];
        }
        while (count < res.length){
            res[count++] = sum;
            right = (right+1) % code.length;
            sum += code[right];
            sum -= code[left];
            left = (left + 1) % code.length;
        }

        return res;
    }

    public static void main(String[] args) {
        DefuseTheBomb_1652 d = new DefuseTheBomb_1652();
        d.decrypt(new int[]{2,4,9,3}, -2);
    }
}
