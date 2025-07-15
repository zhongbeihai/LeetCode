package com.two_pointers;

public class MinimumLengthOfStringAfterDeletingSimilarEnds_1750 {
    public int minimumLength(String s) {
        int head = 0, rear = s.length() - 1;
        char[] ss = s.toCharArray();
        while (head != rear && ss[head] == ss[rear]){
            // char pr = s.charAt(rear), ph = s.charAt(head);
            while (head + 1 != rear && ss[head + 1] == ss[head]){
                head++;
            }
            while (rear - 1 != head && ss[rear - 1] == ss[rear]){
                rear --;
            }
            if (rear - head == 1) return 0;
            head++;
            rear--;

        }

        return rear - head + 1;
    }

    public static void main(String[] args) {
        MinimumLengthOfStringAfterDeletingSimilarEnds_1750 m = new MinimumLengthOfStringAfterDeletingSimilarEnds_1750();
        m.minimumLength("abbbbbbbbbbbbbbbbbbba");
    }
}
