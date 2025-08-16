package com.two_pointers;

public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int[] r = new int[n], l = new int[n];

        l[0] = height[0];
        for (int i = 1; i < n; i++) {
            l[i] = Math.max(l[i - 1], height[i]);
        }

        r[n - 1] = height[n - 1];
        for (int j = n - 2; j >= 0; j--){
            r[j] = Math.max(r[j + 1], height[j]);
        }

        int res = 0;
        for (int i = 0; i < n; i++){
            res += Math.min(l[i], r[i]) - height[i];
        }

        return res;
    }

    public int twoPointers(int[] height){
        int n = height.length, res = 0;
        int left = 0, right = n - 1;

        int left_highest = height[0];
        int right_highest = height[n - 1];
        while (left <= right){
            left_highest = Math.max(left_highest, height[left]);
            right_highest = Math.max(right_highest, height[right]);

            if (left_highest < right_highest){
                res += left_highest - height[left];
                left++;
            }else {
                res += right_highest - height[right];
                right--;
            }
        }

        return res;
    }
}
