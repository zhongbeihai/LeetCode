package com.stack;

import java.util.*;
import java.util.stream.Collectors;

public class FindTheFirstPlayerToWinKGamesInARow_3175 {
    public int findWinningPlayer(int[] skills, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < skills.length; i++) {
            map.put(skills[i], i);
        }
        if(k > skills.length){
            Arrays.sort(skills);
            return map.get(skills[skills.length - 1]);
        }
        ArrayDeque<Integer> queue = Arrays.stream(skills).boxed().collect(Collectors.toCollection(ArrayDeque::new));
        int count = 0;
        int lastWin = queue.peek();
        while (count < k) {
            int first = queue.pollFirst();
            int second = queue.pollFirst();
            if (first > second) {
                queue.addFirst(first);
                queue.addLast(second);
                if(first != lastWin) count=0;
                lastWin = first;
            }else {
                queue.addFirst(second);
                queue.addLast(first);
                if(second != lastWin) count = 0;
                lastWin = second;
            }
            count++;
        }
        return map.get(lastWin);
    }

    public static void main(String[] args) {
        FindTheFirstPlayerToWinKGamesInARow_3175 f = new FindTheFirstPlayerToWinKGamesInARow_3175();
        f.findWinningPlayer(new int[]{11,13,10,15,14,9,12,6}, 2);
    }
}
