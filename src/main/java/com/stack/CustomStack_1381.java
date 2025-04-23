package com.stack;

class CustomStack {
    int[] stack;
    int pointer = -1;
    public CustomStack(int maxSize) {
        stack = new int[maxSize];
    }

    public void push(int x) {
        if(pointer == stack.length-1) return;
        stack[++pointer] = x;
    }

    public int pop() {
        if(pointer == -1) return -1;
        return stack[pointer--];
    }

    public void increment(int k, int val) {
        if(k > pointer + 1) {
            k = pointer;
            for(int i = 0; i <= k ; i++){
                stack[i] += val;
            }
        }else{
            for(int i = 0; i < k ; i++){
                stack[i] += val;
            }
        }

    }

    public static void main(String[] args) {
        CustomStack s = new CustomStack(3);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.increment(2, 100);
    }
}
