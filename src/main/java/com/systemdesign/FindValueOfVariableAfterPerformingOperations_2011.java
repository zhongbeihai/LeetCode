package com.systemdesign;

public class FindValueOfVariableAfterPerformingOperations_2011 {
    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for (String o: operations){
            if (o.contains("-")) ans--;
            else ans++;
        }

        return ans;
    }
}
