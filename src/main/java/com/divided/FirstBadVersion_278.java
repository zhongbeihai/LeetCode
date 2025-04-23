package com.divided;

public class FirstBadVersion_278 {
    boolean isBadVersion(int version){
        if(version >= 1702766719){
            return true;
        }else {
            return false;
        }
    }
    public int firstBadVersion(int n) {
        long start = 0, end = n, mid = (int)(start + end) /2;
        while(start < end){
            if(start == mid) return (int)end;
            int i = (int)mid;
            if(isBadVersion(i)){
                end = mid;
                mid = (start + end) / 2;
            }else {
                start = mid;
                mid = (start + end) / 2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstBadVersion_278 f = new FirstBadVersion_278();
        f.firstBadVersion(2126753390);
    }
}
