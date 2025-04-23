package com.simulation;

public class GasStation_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int p = 0; p < gas.length; p++){
            int get = 0;
            int cnt = 0;
            for(int i = p; i < gas.length * 5; i = (i + 1) % gas.length){
                get += gas[i] - cost[i];
                if(get < 0) {
                    if(i > p) p = i;
                    break;
                }
                cnt++;
                if(cnt > gas.length) return p;

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        GasStation_134 h = new GasStation_134();
        h.canCompleteCircuit(new int[]{1,1,1}, new int[]{1,1,1});
    }
}
