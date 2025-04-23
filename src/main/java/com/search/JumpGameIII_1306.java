package com.search;

public class JumpGameIII_1306 {
    public boolean canReach(int[] arr, int start) {
        return dfs(arr, start);
    }

    public boolean dfs(int[] arr, int start){
        if(arr[start]  == 0) return true;
        boolean right = false, left = false;
        int r = start + arr[start];
        int l = start - arr[start];
        arr[start] = -arr[start];
        if(r < arr.length && arr[r] >= 0){
            right = dfs(arr, r);
        }
        if(l >= 0 && arr[l] >= 0){
            left = dfs(arr, l);
        }
        return left || right;
    }

    public static void main(String[] args) {
        JumpGameIII_1306 j = new JumpGameIII_1306();
        j.canReach(new int[]{0,1}, 1);
    }
}
