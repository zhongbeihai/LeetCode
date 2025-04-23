package com.dequeue_and_priorityqueue;

import java.util.LinkedList;

public class FindTheWinnerOfTheCircleGame_1823 {
    public int findTheWinner(int n, int k) {
        LinkedList<Integer> ll = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            ll.add(i);
        }

        int count = 0;
        while (ll.size() != 1){
            count = (count + k - 1) % ll.size();
            ll.remove(count);
        }

        return ll.getLast();
    }

    public static void main(String[] args) {
        FindTheWinnerOfTheCircleGame_1823 f  = new FindTheWinnerOfTheCircleGame_1823();
        f.findTheWinner(5, 2);
    }
}
