package com.simulation;

public class MaximizeDistanceToClosetPerson_849 {
    public int maxDistToClosest(int[] seats) {
        int i = 0, j = 0, n = seats.length, f = -1, res = -1;
        while (j < n){
            if (seats[j] == 1){
                if (f == -1) f = j;
                int mid = (j - 1) / 2;
                res = Math.max(res, mid);
                i = j;
            }
            j++;
        }

        if (seats[0] != 1){
            res = Math.max(res, f);
        }

        if (seats[n - 1] != 1){
            res = Math.max(res, j - 1 - i);
        }

        return res;
    }

    public static void main(String[] args) {
        MaximizeDistanceToClosetPerson_849 m = new MaximizeDistanceToClosetPerson_849();
        m.maxDistToClosest(new int[]{0,1,0,1,0});
    }
}
