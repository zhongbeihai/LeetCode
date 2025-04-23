package com.dequeue_and_priorityqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class FindTheLongestEqualSubarray_2831 {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        HashMap<Integer, List<Integer>> numToIndices = new HashMap<>();
        for(int i = 0; i < nums.size(); i++){
            int a = nums.get(i);
            if(numToIndices.get(a) == null){
                List<Integer> l = new ArrayList<>();
                l.add(i);
                numToIndices.put(a, l);
            }else {
                List<Integer> l = numToIndices.get(a);
                l.add(i);
            }
        }

        int maxx = 1;
        for(List<Integer> list: numToIndices.values()){
            int l = 0, r = 0, tem = k;
            int cnt = 1;
            if(list.size() == 1) continue;
            while (r < list.size() - 1){
                int gap = list.get(r + 1) - list.get(r) - 1;
                if(tem >= gap){
                    tem -= gap;
                    r++;
                    cnt++;
                    maxx = Math.max(maxx, cnt);
                }else{
                    tem += list.get(l + 1) - list.get(l) - 1;
                    l++;
                    cnt--;
                }
            }
        }

        return maxx;
    }

    public static void main(String[] args) {
        FindTheLongestEqualSubarray_2831 f = new FindTheLongestEqualSubarray_2831();
        int[] arr = new int[]{1,3,2,3,1,3};
        ArrayList<Integer> l = Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new));
        f.longestEqualSubarray(l, 3);
    }
}
