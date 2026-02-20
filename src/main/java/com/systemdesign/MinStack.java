package com.systemdesign;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MinStack {
    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> curMin = new ArrayDeque<>();

    public MinStack(){}

    public void push(int val) {
        stack.push(val);
        if (curMin.isEmpty() || val <= curMin.peek()) curMin.push(val);
        else curMin.push(curMin.peek());
    }

    public void pop() {
        stack.pop();
        curMin.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return curMin.peek();
    }
}
