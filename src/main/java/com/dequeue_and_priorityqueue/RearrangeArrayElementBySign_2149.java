package com.dequeue_and_priorityqueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class RearrangeArrayElementBySign_2149 {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        Queue<Integer> posi = new ArrayDeque<>();
        Queue<Integer> neg = new ArrayDeque<>();
        for (int num : nums) {
            if (num > 0) posi.add(num);
            else neg.add(num);
        }

        boolean flag = true;
        int i = 0;
        while (!posi.isEmpty() && !neg.isEmpty()){
            nums[i++] = flag ? posi.poll() : neg.poll();

            flag = !flag;
        }

        return nums;
    }
}
