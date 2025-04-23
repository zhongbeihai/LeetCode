package com.sliding_windows;

import java.util.*;
import java.util.stream.Collectors;

public class FindKClosestElements_658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int head = 0, rear = 0;
        Queue<Integer> res = new LinkedList<>();
        while (rear < arr.length && rear - head < k){
            res.add(arr[rear]);
            rear++;
        }
        while (rear < arr.length){

            if(Math.abs(arr[rear] - x) < Math.abs(arr[head] - x)){
                res.offer(arr[rear]);
                res.poll();

            }
            head++;
            rear++;
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        FindKClosestElements_658 f = new FindKClosestElements_658();
        f.findClosestElements(new int[] {-2,-1,1,2,3,4,5,6,7,8,9}, 4, 2);
        f.findClosestElements(new int[]{1},1,1);
    }
}
