package com.tsj.algorithm.leetcode;

import java.util.Stack;

/**
 * @Author tansj
 * @Date 2022/9/1 09:08
 * @Version 1.0
 */
public class _1475 {

    /**
     * 1475. 商品折扣后的最终价格
     * <p>
     * <p>
     * 给你一个数组 prices ，其中 prices[i] 是商店里第 i 件商品的价格。
     * 商店里正在进行促销活动，如果你要买第 i 件商品，那么你可以得到与 prices[j] 相等的折扣，其中 j 是满足 j > i 且 prices[j] <= prices[i] 的 最小下标 ，
     * 如果没有满足条件的 j ，你将没有任何折扣。
     * 请你返回一个数组，数组中第 i 个元素是折扣后你购买商品 i 最终需要支付的价格。
     *
     * @param prices
     * @return
     */
    public int[] finalPrices(int[] prices) {
        //单调栈
        Stack<Integer> stack = new Stack<>();
        for (int i = prices.length - 1; i >= 0; i--) {
            int price = prices[i];
            while (!stack.isEmpty() && stack.peek() > price) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                prices[i] = price - stack.peek();
            }
            stack.push(price);
        }
        return prices;
    }

}
