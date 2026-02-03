package lc100hot;

import java.util.HashMap;
import java.util.Map;

public class A {
    static class Node{
        Node prev, next;
        int key, val;

        public Node(int key, int val) {
            key = key;
            val = val;
        }
    }

    private Node head, tail;
    Map<Integer, Node> map = new HashMap<>();
    int capacity;

    A(int capacity){
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        if (map.containsKey(key)) {
            update(map.get(key));
            return map.get(key).val;
        }

        return -1;
    }

    public void put(int key, int val){
        if (map.containsKey(key)){
            Node n = map.get(key);
            n.val = val;
            update(n);
        }else {
            Node n = new Node(key, val);
            map.put(key, n);
            n.next = head.next;
            n.prev = head;

            head.next = n;
        }

        while (map.size() > capacity){
            pop();
        }
    }

    public void update(Node node){
        remove(node);
        moveToHead(node);
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void moveToHead(Node n){
        n.next = head.next;
        n.prev = head;

        head.next = n;
        head.next.prev = n;
    }

    public void pop(){
        Node last = tail.prev;

        map.remove(last.key);
        last.prev.next = tail;
    }
}
