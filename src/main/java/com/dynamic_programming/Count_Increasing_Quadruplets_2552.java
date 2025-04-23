package com.dynamic_programming;

public class Count_Increasing_Quadruplets_2552 {
    public long countQuadruplets(int[] nums) {
        int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE, m3 = Integer.MAX_VALUE, m4 = Integer.MAX_VALUE;

        long count = 0L;
        for(int num: nums){
            if(num <= m1){
                m1 = num;
                if(m2 != Integer.MAX_VALUE && m3 != Integer.MAX_VALUE && m4 != Integer.MAX_VALUE){
                    count++;
                }
            } else if (num <= m2) {
                m2 = num;
                if(m1 != Integer.MAX_VALUE && m3 != Integer.MAX_VALUE && m4 != Integer.MAX_VALUE){
                    count++;
                }
            } else if (num <= m3) {
                m3 = num;
                if(m2 != Integer.MAX_VALUE && m1 != Integer.MAX_VALUE && m4 != Integer.MAX_VALUE){
                    count++;
                }
            } else if (num <= m4) {
                m4 = num;
                if(m2 != Integer.MAX_VALUE && m3 != Integer.MAX_VALUE && m1 != Integer.MAX_VALUE){
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Count_Increasing_Quadruplets_2552 c = new Count_Increasing_Quadruplets_2552();
        c.countQuadruplets(new int[]{1,3,2,4,5});
    }
}
