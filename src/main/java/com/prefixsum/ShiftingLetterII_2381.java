package com.prefixsum;

public class ShiftingLetterII_2381 {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] diff = new int[s.length() + 1]; // 差分数组

        // 更新差分数组
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2] == 1 ? 1 : -1; // 1: 正向移位, 0: 反向移位

            diff[start] += direction;
            if (end + 1 < diff.length) {
                diff[end + 1] -= direction;
            }
        }

        int[] prefixSum = new int[s.length()];
        int currentSum = 0;
        for (int i = 0; i < s.length(); i++) {
            currentSum += diff[i];
            prefixSum[i] = currentSum;
        }
        // 构造结果字符串
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 计算相对位置并调整
            int shiftedPosition = ((c - 'a') + prefixSum[i]) % 26;
            if (shiftedPosition < 0) {
                shiftedPosition += 26; // 确保偏移量非负
            }

            // 转换回字符
            c = (char) ('a' + shiftedPosition);
            sb.append(c);
        }

        return sb.toString();
    }
}
