package com.simulation;

import java.util.concurrent.ForkJoinPool;

class FooBar {
    private int n;
    private volatile boolean flag = true;
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (!flag){
                Thread.yield();
            }
            System.out.print("foo");
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            flag = false;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (flag){
                Thread.yield();
            }
            System.out.print("bar");
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            flag = true;
        }
    }
}