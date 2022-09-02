package com.tsj.algorithm.leetcode;

/**
 * @Author tansj
 * @Date 2022/9/2 14:43
 * @Version 1.0
 */
public class _1281 {

    /**
     * 1281. 整数的各位积和之差
     * <p>
     * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
     *
     * @param n
     * @return
     */
    public int subtractProductAndSum(int n) {
        int a = 1;
        int b = 0;
        int t = 10;
        while (n > 0) {
            a *= (n % t);
            b += (n % t);
            n /= t;
        }
        return a - b;
    }

}
