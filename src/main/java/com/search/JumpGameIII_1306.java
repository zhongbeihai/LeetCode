package com.search;

public class JumpGameIII_1306 {
    public boolean canReach(int[] arr, int start) {
        return dfs(arr, start);
    }

    public boolean dfs(int[] arr, int start){
        if (start < 0 || start >= arr.length) return false;
        if (arr[start] == 0) return true;
        if (arr[start] < 0) return false; // already visited

        int step = arr[start];
        arr[start] = -arr[start]; // mark visited

        // to right
        boolean right = dfs(arr, start + step);

        // to left
        boolean left = dfs(arr, start - step);

        return left || right;
    }

    public static void main(String[] args) {
        JumpGameIII_1306 j = new JumpGameIII_1306();
        j.canReach(new int[]{4,2,3,0,3,1,2}, 5);
    }
}
