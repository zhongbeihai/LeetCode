package com.simulation;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LRUCache_146 {
     static class Node{
         int k, v;
         Node prev, next;
         Node(int key, int val){
             k = key;
             v = val;
         }
     }

     private int capacity;
     Node head = new Node(-1, -1);
     Node tail = new Node(-1, -1);
     Map<Integer, Node> map = new HashMap<>();
     public LRUCache_146(int capacity){
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
     }

    public int get(int key) {
        Node n = map.get(key);
        if (n == null) return -1;

        update(n);
        return n.v;
    }

    public void put(int key, int value) {
        Node n = map.get(key);
        if (n != null){
            n.v = value;
            update(n);
            return;
        }
        n = new Node(key, value);
        map.put(key, n);
        moveAfterHead(n);
        if (map.size() > capacity){
            Node p = pop();
            map.remove(p.k);
        }
    }

    public void update(Node x){
         remove(x);
         moveAfterHead(x);
    }

    public void moveAfterHead(Node x){
         x.next = head.next;
         x.prev = head;

         head.next = x;
         x.next.prev = x;
    }

    public void remove(Node x){
         x.next.prev = x.prev;
         x.prev.next = x.next;
    }

    public Node pop(){
         Node n = tail.prev;

         remove(n);
         return n;
    }
}
