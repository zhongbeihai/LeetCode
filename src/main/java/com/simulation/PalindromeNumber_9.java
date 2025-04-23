package com.simulation;

public class PalindromeNumber_9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        char[] xx = String.valueOf(x).toCharArray();
        int front = 0, rear = xx.length - 1;
        while (front <= rear){
            if (xx[front] != xx[rear]) return false;
            front++;
            rear--;
        }

        return true;
    }
}
