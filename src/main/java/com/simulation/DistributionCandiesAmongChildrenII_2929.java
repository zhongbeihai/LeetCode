package com.simulation;

import javax.xml.bind.annotation.XmlInlineBinaryData;

public class DistributionCandiesAmongChildrenII_2929 {
    public long distributeCandies(int n, int limit) {
        long res = 0;
        for (int i = 0; i <= Math.min(limit, n); i++){
            res += Math.max(Math.min(limit, n - i) - Math.max(0, n - i - limit) + 1, 0);
        }

        return res;
    }

    public long jieCheng(int m, int n){
        long res = 1;
        for (int i = n; i >= n - m - 1; i--){
            res *= i;
        }

        return res;
    }

    public static void main(String[] args) {
        DistributionCandiesAmongChildrenII_2929 d = new DistributionCandiesAmongChildrenII_2929();
        d.distributeCandies(3, 3);
    }
}
