package com.two_pointers;

public class FindTheIndexOfFirstOccurrenceInAString_28 {
    public int strStr(String haystack, String needle) {
        int p1 = 0, p2 = 0;

        while (p1 < haystack.length()){
            while (haystack.charAt(p1) == needle.charAt(p2)){
                p1++;
                p2++;
                if (p2 == needle.length()) return p1;
            }

            p2 = p1;
        }

        return -1;
    }

    public static void main(String[] args) {
        FindTheIndexOfFirstOccurrenceInAString_28 f = new FindTheIndexOfFirstOccurrenceInAString_28();
        f.strStr("sadbutsad", "sad");
    }
}
