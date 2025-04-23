package com.simulation;

import java.util.Arrays;
import java.util.HashSet;

public class TupleWithSameProduct_1726 {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length, N = n * (n - 1) / 2;
        int[] product = new int[N];

        int idx = 0;
        for (int i = 0; i < n - 1; i++){
            for (int j = i + 1; j < n; j++){
                product[idx++] = nums[i] * nums[j];
            }
        }

        Arrays.sort(product);

        int f = 1, ans = 0;
        for (int i = 1; i < product.length; i++){
            if (product[i] == product[i - 1]) f++;
            else {
                if (f > 1) ans += f * (f - 1) * 4;
                f = 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        TupleWithSameProduct_1726 t = new TupleWithSameProduct_1726();
        t.tupleSameProduct(new int[]{2,3,4,6,8,12});
    }
}
