package com.simulation;

public class MinimizeXOR_2429 {
    public int minimizeXor(int num1, int num2) {
        int count = Integer.bitCount(num2);

        int x = 0;

        for (int i = 31; i >= 0; i--) {
            if ((num1 & (1 << i)) != 0) { // num1 当前位是 1
                if (count > 0) { // 如果还需要 1
                    x |= (1 << i); // 在相同的位置设置为 1
                    count--; // 减少需要的 1 数量
                }
            }
        }

        // 如果还有剩余的 1，需要从低位开始补充
        for (int i = 0; i <= 31; i++) {
            if (count == 0) break; // 如果已经满足了所有 1，则退出
            if ((x & (1 << i)) == 0) { // 如果当前位是 0
                x |= (1 << i); // 将当前位设置为 1
                count--; // 减少需要的 1 数量
            }
        }

        return x;
    }
}
