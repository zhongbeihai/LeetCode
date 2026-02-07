package lc100hot;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;



public class ConcurrentAccount {
    private ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();

    private boolean transfer(String fromAccountID, String toAccountID, int amount){
        if(map.get(fromAccountID) < amount) return false;
        else map.put(fromAccountID, map.get(fromAccountID) - amount);

        map.put(toAccountID, map.get(toAccountID) + amount);

        return true;
    }
}