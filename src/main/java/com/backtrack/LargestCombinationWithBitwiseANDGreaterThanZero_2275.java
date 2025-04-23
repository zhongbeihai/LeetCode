package com.backtrack;

import javafx.util.Pair;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestCombinationWithBitwiseANDGreaterThanZero_2275 {
    public int largestCombination(int[] candidates) {
        int maxBitwiseValue = 0;
        for (int num : candidates) {
            maxBitwiseValue |= num;
        }

        int[] dp = new int[maxBitwiseValue + 1];
        dp[0] = 0;

        for (int num : candidates) {
            int[] newDp = dp.clone(); // 复制当前 dp 状态
            for (int andVal = 0; andVal <= maxBitwiseValue; andVal++) {
                if (dp[andVal] > 0 || andVal == 0) { // 只更新有效状态
                    int newAndVal = andVal & num;
                    newDp[newAndVal] = Math.max(newDp[newAndVal], dp[andVal] + 1);
                }
            }
            dp = newDp; // 更新 dp 数组
        }

        // 找到 AND > 0 的最大子集大小
        int maxSize = 0;
        for (int andVal = 1; andVal <= maxBitwiseValue; andVal++) {
            maxSize = Math.max(maxSize, dp[andVal]);
        }

        return maxSize;
    }

//    public void backtracking(int[] candidates, int start,List<Integer> tem){
//        int bitwiseAnd = tem.stream().reduce((a,b) -> a & b).orElse(0);
//        if(bitwiseAnd > 0 && tem.size() > list.size()){
//            list = new ArrayList<>(tem);
//        }
//        if(tem.size() == candidates.length) return;
//
//        for(int i = start; i < candidates.length; i++){
//            tem.add(candidates[i]);
//
//            backtracking(candidates, i + 1, tem);
//
//            tem.remove(tem.size() - 1);
//        }
//
//    }

    public static void main(String[] args) {
        LargestCombinationWithBitwiseANDGreaterThanZero_2275 l = new LargestCombinationWithBitwiseANDGreaterThanZero_2275();
        l.largestCombination(new int[]{16,17,71,62,12,24,14});
    }
}
