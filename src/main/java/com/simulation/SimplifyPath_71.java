package com.simulation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

public class SimplifyPath_71 {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        ArrayDeque<String> deque = new ArrayDeque<>();
        for(String p : paths){
            if(p.equals("") || p.equals(".")) continue;
            if(p.equals("..")){
                if(!deque.isEmpty()) {
                    deque.removeLast();
                }
                continue;
            }
            deque.addLast("/" + p);
        }
        if(deque.isEmpty()) deque.add("/");
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()){
            sb.append(deque.removeFirst());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SimplifyPath_71 s = new SimplifyPath_71();
        s.simplifyPath("/.../a/../b////c/../d/./");
    }
}
