package com.simulation;

public class CountAndSay_38 {
    public String countAndSay(int n) {
        return recursive(n);
    }

    public String recursive(int n){
        if (n == 1) return "1";
        String ori = recursive(n - 1);

        String res = getRLE(ori);

        return res;
    }

    public String getRLE(String ori){
        char[] cc = ori.toCharArray();
        int left= 0, right = left;

        StringBuilder sb = new StringBuilder();
        while (right < ori.length()){
            int count = 0;
            while (right < ori.length() && cc[right] == cc[left]){
                count++;
                right++;
            }
            left = right;
            sb.append(count).append(cc[left- 1] - '0');
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        CountAndSay_38 c = new CountAndSay_38();
        c.countAndSay(4);
    }
}
