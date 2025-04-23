package com.doublepointers;

import java.util.Arrays;

public class FriendsOfAppropiateAges_825 {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int[] ageCnt = new int[121];
        int res = 0;
        for (int x = 0; x < ages.length; x++){
            int low = 0, high = x - 1, validLowBound = -1;
            // find the valid low bound
            while (low <= high){
                int mid = low + (high - low) / 2;
                if (ages[x] * 0.5 + 7 >= ages[mid]){
                    low = mid + 1;
                }else {
                    high = mid - 1;
                    validLowBound = mid;
                }
            }

            if (validLowBound != -1){
                res += x - validLowBound;
                res += ageCnt[ages[x]];
            }
            ageCnt[ages[x]]++;
        }

        return res;
    }

    public static void main(String[] args) {
        FriendsOfAppropiateAges_825 f= new FriendsOfAppropiateAges_825();
        f.numFriendRequests(new int[]{20,30,100,110,120});
    }
}
