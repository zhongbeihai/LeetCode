package com.dynamic_programming;

public class MostProfitAssigningWork_826 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int maxProfit = 0;
        for(int i = 0; i < worker.length; i++){
            int personProfit = 0;
            for(int j = 0; j < difficulty.length; j++){
                if(worker[i] >= difficulty[j]){
                    personProfit = Math.max(personProfit, profit[j]);
                }
            }
            maxProfit += personProfit;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        MostProfitAssigningWork_826 m = new MostProfitAssigningWork_826();
        m.maxProfitAssignment(new  int[]{2,4,6,8,10}, new int[]{10,20,30,40,50}, new int[]{4,5,6,7});
    }
}
