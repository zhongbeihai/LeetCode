package com.simulation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

public class SimplifyPath_71 {
    public String simplifyPath(String path) {
        String[] sep = path.split("/");

        ArrayDeque<String> deque = new ArrayDeque<>();
        
        for (String p: sep){
            if (p.equals(".") || p.isEmpty()) {
            } else if (p.equals("..")) {
                deque.pollLast();
            }else {
                deque.addLast("/" + p);
            }
        }

        if (deque.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()){
            sb.append(deque.pollFirst());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SimplifyPath_71 s = new SimplifyPath_71();
        s.simplifyPath("/.../a/../b////c/../d/./");
    }
}
