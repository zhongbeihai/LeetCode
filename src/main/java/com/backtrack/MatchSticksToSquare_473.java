package com.backtrack;

import java.util.Arrays;

public class MatchSticksToSquare_473 {
    public boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        if(sum % 4 != 0 ) return false;
        sum = sum / 4;
        int[] target = new int[4];
        Arrays.fill(target, sum);
        for (int matchstick : matchsticks) {
            if (matchstick > sum) return false;
        }
        return backtracing(matchsticks, 0, target);
    }

    public boolean backtracing(int[] matchsticks, int index, int[] target){
        if(index == matchsticks.length) return true;

        for(int i = 0; i < target.length; i++){
            if(matchsticks[index] <= target[i]){
                target[i] -= matchsticks[index];
                if( backtracing(matchsticks, index + 1, target)){
                    return true;
                }
                target[i] += matchsticks[index];
            }
        }

        return false;
    }

    public static void main(String[] args) {
        MatchSticksToSquare_473 m = new MatchSticksToSquare_473();
        m.makesquare(new int[]{10,6,5,5,5,3,3,3,2,2,2,2});
    }
}
