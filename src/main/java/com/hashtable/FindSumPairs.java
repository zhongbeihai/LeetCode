package com.hashtable;

import java.util.HashMap;
import java.util.Set;

class FindSumPairs {
    private HashMap<Integer, Integer> nums1;
    private HashMap<Integer, Integer> nums2;
    private int[] dic;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = new HashMap<>();
        this.nums2 = new HashMap<>();

        for (int n: nums1){
            this.nums1.put(n, this.nums1.getOrDefault(n, 0) + 1);
        }

        for (int n: nums2){
            this.nums2.put(n, this.nums2.getOrDefault(n, 0) + 1);
        }
        this.dic = nums2;
    }

    public void add(int index, int val) {
        int value = dic[index];
        this.nums2.put(value, this.nums2.get(value) - 1);
        if (this.nums2.get(value) == 0) this.nums2.remove(value);

        this.nums2.put(value + val, this.nums2.getOrDefault(value + val, 0) + 1);
        this.dic[index] = value + val;
    }

    public int count(int tot) {
        Set<Integer> keySetNums1 = this.nums1.keySet();
        Set<Integer> keySetNums2 = this.nums2.keySet();

        int res = 0;
        for (int k : keySetNums1){
            if (keySetNums2.contains(tot - k)){
                res += nums2.get(tot - k) * nums1.get(k);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        FindSumPairs f = new FindSumPairs(new int[]{1,1,2,2,2,3}, new int[]{1,4,5,2,5,4});
        f.count(7);
    }
}
