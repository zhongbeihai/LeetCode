package com.systemdesign;

import structure.ListNode;

import java.security.Key;
import java.util.LinkedList;
import java.util.List;

public class DesignHashMap_706 {
    class KeyValueNode{
        int key, val;
        KeyValueNode next;
        KeyValueNode(int k , int v){
            key = k;
            val = v;
        }
    }
    KeyValueNode[] bucket;
    public DesignHashMap_706() {
        this.bucket = new KeyValueNode[100];
    }

    public void put(int key, int value) {
        int hash = Math.floorMod(Integer.hashCode(key), bucket.length);
        KeyValueNode n = new KeyValueNode(key, value);
        if (bucket[hash] == null) {
            bucket[hash] = n;
            return;
        }
        KeyValueNode p = bucket[hash];
        while (p.next != null && p.key != key){
            p = p.next;
        }

        if (p.key == key){
            p.val = value;
        }else {
            p.next = n;
        }
    }

    public int get(int key) {
        int hash = Math.floorMod(Integer.hashCode(key), bucket.length);
        KeyValueNode p = bucket[hash];
        while (p != null && p.key != key){
            p = p.next;
        }

        return p != null ? p.val : -1;
    }

    public void remove(int key) {
        int hash = Math.floorMod(Integer.hashCode(key), bucket.length);
        KeyValueNode p = bucket[hash];
        if (p == null) return;
        if(p.key == key) {bucket[hash] = null; return;}

        KeyValueNode prev = p;
        while (prev.next != null && prev.next.key != key){
            prev = prev.next;
        }
        if (prev.next != null){
            prev.next = prev.next.next;
        }
    }
}
