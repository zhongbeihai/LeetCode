package com.simulation;

import org.omg.CosNaming.IstringHelper;

import java.util.Stack;
import java.util.TreeMap;

public class UsingARobotToPrintTheLexicographicallySmallestString_2434 {
    public String robotWithString(String s) {
        int[] freq = new int[26]; // 记录每个字符出现的次数
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        int minCharIndex = 0; // 当前有效最小字符

        for (char c : s.toCharArray()) {
            stack.push(c);
            freq[c - 'a']--;

            // 更新 minCharIndex（下一个还存在的最小字符）
            while (minCharIndex < 26 && freq[minCharIndex] == 0) {
                minCharIndex++;
            }

            // 只要栈顶字符 <= 当前剩余最小字符，就可以输出
            while (!stack.isEmpty() && (stack.peek() - 'a') <= minCharIndex) {
                result.append(stack.pop());
            }
        }

        // 输出剩余栈中字符
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        UsingARobotToPrintTheLexicographicallySmallestString_2434 u = new UsingARobotToPrintTheLexicographicallySmallestString_2434();
        u.robotWithString("vzhofnpo");
    }
}
