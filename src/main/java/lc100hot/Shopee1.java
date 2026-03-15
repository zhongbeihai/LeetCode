package lc100hot;

import java.util.*;

public class Shopee1 {
    public int getResult(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        int i = arr.length - 2;

        while (i >= 0 && arr[i] >= arr[i + 1]) i--;

        if (i < 0) return -1;

        int j = arr.length - 1;
        while (j > i && arr[j] <= arr[i]) j--;
        char tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;

        int l = i + 1, r = arr.length - 1;
        while (l < r){
            tem = arr[l];
            arr[l] = arr[r];
            arr[r] = tem;
            l++;
            r--;
        }

        long ans = Long.parseLong(new String(arr));

        return (int) ans;
    }

    public String[] longestPalindrome(String inPutStr) {
        if(inPutStr == null || inPutStr.isEmpty()) return new String[0];

        int n = inPutStr.length();
        boolean[][] dp = new boolean[n][n];
        Set<String> set = new LinkedHashSet<>();
        int maxL = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (inPutStr.charAt(i) == inPutStr.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])){
                    dp[j][i] = true;
                    int len = i - j + 1;
                    if (len > maxL){
                        maxL = len;
                        set.clear();
                        set.add(inPutStr.substring(j, i + 1));
                    }else if (len == maxL) set.add(inPutStr.substring(j, i + 1));
                }
            }
        }

        return set.toArray(new String[0]);
    }

    public int ForceIncreaseAarry(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);

        int m = 0;
        for (int i = 0; i < arr2.length; i++) {
            if(i == 0 || arr2[i] != arr2[i - 1]) arr2[m++] = arr2[i];
        }

        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(Integer.MIN_VALUE, 0);

        for (int num: arr1){
            Map<Integer, Integer> next = new HashMap<>();

            for (Map.Entry<Integer, Integer> e: dp.entrySet()){
                int prev = e.getKey(), cost = e.getValue();
                if (num > prev) next.put(num, Math.min(next.getOrDefault(num, Integer.MAX_VALUE), cost));

                int idx = upperBound(arr2, m, prev);
                if (idx < m){
                    int rep = arr2[idx];
                    next.put(rep, Math.min(next.getOrDefault(rep, Integer.MAX_VALUE), cost + 1));
                }
            }

            if (next.isEmpty()) return -1;
            dp = next;
        }

        int ans = Integer.MAX_VALUE;
        for (int cost: dp.values()) ans = Math.min(ans, cost);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int upperBound(int[] arr, int len, int target){
        int left = 0, right = len;
        while (left < right){
            int mid = left + (right - left) / 2;
            if(arr[mid] <= target){
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        return left;
    }
}
