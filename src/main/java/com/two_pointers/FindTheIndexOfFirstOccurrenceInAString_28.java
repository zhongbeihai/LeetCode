package com.two_pointers;

public class FindTheIndexOfFirstOccurrenceInAString_28 {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)){
                int p1 = 0;
                while (i + p1 < haystack.length() && p1 < needle.length()
                        && haystack.charAt(i + p1) == needle.charAt(p1)) p1++;
                if (p1 == needle.length()) return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FindTheIndexOfFirstOccurrenceInAString_28 f = new FindTheIndexOfFirstOccurrenceInAString_28();
        // f.strStr("mississippi", "issip");
        f.strStr("a", "a");
    }
}
