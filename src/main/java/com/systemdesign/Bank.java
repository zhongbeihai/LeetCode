package com.systemdesign;

public class Bank {
    int n;
    long[] balance;
    public Bank(long[] balance) {
        this.n = balance.length;
        this.balance = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        synchronized (this){
            if (account1 > n || account2 > n || balance[account1 - 1] < money) return false;
            balance[account1 - 1] -= money;
            balance[account2 - 1] += money;
        }

        return true;
    }

    public boolean deposit(int account, long money) {
        if (account > n) return false;
        synchronized (this){
            balance[account - 1] += money;
        }

        return true;
    }

    public boolean withdraw(int account, long money) {
        if (account > n) return false;
        synchronized (this){
            if (balance[account - 1] < money) return false;

            balance[account - 1] -= money;
        }

        return true;
    }
}
