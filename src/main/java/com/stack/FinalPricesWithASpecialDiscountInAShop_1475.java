package com.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * You are given an integer array prices where prices[i] is the price of the ith item in a shop.
 * There is a special discount for items in the shop. If you buy the ith item,
 * then you will receive a discount equivalent to prices[j] where j
 * is the minimum index such that j > i and prices[j] <= prices[i].
 * Otherwise, you will not receive any discount at all.
 * Return an integer array answer where answer[i] is
 * the final price you will pay for the ith item of the shop, considering the special discount.
 * Input: prices = [8,4,6,2,3]
 * Output: [4,2,4,2,3]
 */
public class FinalPricesWithASpecialDiscountInAShop_1475 {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[prices.length];
        for(int i = 0; i < prices.length; i++){
            while(!stack.isEmpty() && prices[stack.peek()] >= prices[i]){
                answer[stack.peek()] = prices[stack.peek()] - prices[i];
                stack.pop();
            }
            stack.add(i);
        }
        while (!stack.isEmpty()){
            answer[stack.peek()] = prices[stack.peek()];
            stack.pop();
        }
        return answer;
    }

    public static void main(String[] args) {
        FinalPricesWithASpecialDiscountInAShop_1475 f = new FinalPricesWithASpecialDiscountInAShop_1475();
        System.out.println(Arrays.toString(f.finalPrices(new int[]{8, 4, 6, 2, 3})));
    }
}
