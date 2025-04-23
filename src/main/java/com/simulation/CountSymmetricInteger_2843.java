package com.simulation;

public class CountSymmetricInteger_2843 {
    public int countSymmetricIntegers(int low, int high){
        int count = 0;

        for(int i = low; i <= high; i++){
            String str = String.valueOf(i);
            int numOfDigit = str.length();
            if (numOfDigit % 2 == 1) continue;
            int fh = 0, rh = 0, half = numOfDigit / 2;
            for (int j = 0; j < half;j++){
                fh += str.charAt(j) - '0';
                rh += str.charAt(j + half) - '0';
            }


            if (rh == fh) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        CountSymmetricInteger_2843 c = new CountSymmetricInteger_2843();
        c.countSymmetricIntegers(1 , 100);
    }
}
