package com.two_pointers;

public class FindTheIndexOfFirstOccurrenceInAString_28 {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) return -1;
        for (int i = 0; i < haystack.length(); i++) {
            int p1 = i, p2= 0;
            while (p1 < haystack.length() && haystack.charAt(p1) == needle.charAt(p2)){
                p1++;
                p2++;
                if (p2 == needle.length()) return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FindTheIndexOfFirstOccurrenceInAString_28 f = new FindTheIndexOfFirstOccurrenceInAString_28();
        // f.strStr("mississippi", "issip");
        f.strStr("ello", "ll");
    }
}
