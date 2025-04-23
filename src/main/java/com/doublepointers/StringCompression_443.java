package com.doublepointers;

public class StringCompression_443 {
    public int compress(char[] chars) {
        if (chars.length == 1) return 1;
        int head = 0, rear = 0;
        StringBuilder sb = new StringBuilder();
        while(rear + 1 < chars.length){
            if (chars[rear + 1] == chars[rear]){
                while (rear + 1 < chars.length && chars[rear + 1] == chars[rear]) rear++;
                sb.append(chars[head]);
                sb.append(rear - head + 1);
            }else {
                sb.append(chars[head]);
            }
            rear++;
            head = rear;
        }
        chars = sb.toString().toCharArray();
        return sb.length();
    }

    public static void main(String[] args) {
        StringCompression_443 s = new StringCompression_443();
        // s.compress(new char[]{'a','a','b','b','c','c','c'});
        s.compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'});
    }
}
