package com.simulation;

public class CalculateMoneyInLeetcodeBank_1716 {
    public int totalMoney(int n) {
        int week = n / 7;
        int rest = n % 7;

        int sum = 0;
        for (int i = 0; i < week; i++){
            sum += 28 + 7 * i;
        }
        for (int i = week + 1; i <= week + rest; i++){
            sum += i;
        }

        return sum;
    }

    public static void main(String[] args) {
        CalculateMoneyInLeetcodeBank_1716 c= new CalculateMoneyInLeetcodeBank_1716();
        c.totalMoney(10);
    }
}
