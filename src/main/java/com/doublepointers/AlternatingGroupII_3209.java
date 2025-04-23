package com.doublepointers;


public class AlternatingGroupII_3209 {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int right = 0, left = right, count = 1;
        int res = 0, len = colors.length;
        while (left < len){
            if (right + 1 < len &&colors[(right+ 1) % len] != colors[right]){
                right = (right + 1) % len;
                count++;
                if (count > k) {
                    left++;
                    count--;
                }
                if (count == k&& left < len) res++;
            }else {
                left++;
                right = left;
                count = 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        AlternatingGroupII_3209 a = new AlternatingGroupII_3209();
        //a.numberOfAlternatingGroups(new int[]{0,1,0,0,1,0,1}, 6);
        a.numberOfAlternatingGroups(new int[]{0,1,0,1}, 3);
    }
}
