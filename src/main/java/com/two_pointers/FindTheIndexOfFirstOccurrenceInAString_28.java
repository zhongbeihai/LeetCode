package com.two_pointers;

public class FindTheIndexOfFirstOccurrenceInAString_28 {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i < n; i++) {
            if (haystack.charAt(i) == needle.charAt(0)){
                if (n - i < m) return -1;
                boolean flag = true;
                for (int j = 0; j < m; j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) return i;
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
