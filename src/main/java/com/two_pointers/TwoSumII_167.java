package com.two_pointers;

public class TwoSumII_167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        int[] res = new int[2];
        while (left < right){
            if (numbers[left] + numbers[right] == target){
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            }
            if (numbers[left] + numbers[right] > target){
                right--;
            }else {
                left++;
            }
        }

        return res;
    }
}
