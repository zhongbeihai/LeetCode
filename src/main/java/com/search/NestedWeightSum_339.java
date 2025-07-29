package com.search;

import structure.NestedInteger;

import java.util.List;

public class NestedWeightSum_339 {
    public int depthSum(List<NestedInteger> nestedList) {
        int sum = 0;
        for (NestedInteger n: nestedList){
            if (n.isInteger()) sum += n.getInteger();
            else sum += dfs(n, 1);
        }

        return sum;
    }

    public int dfs(NestedInteger n, int depth) {
        if (n.isInteger()) return n.getInteger() * depth;

        int sum = 0;
        List<NestedInteger> list = n.getList();
        for (NestedInteger nn : list) {
            sum += dfs(nn, depth + 1);
        }
        return sum;

    }
}
