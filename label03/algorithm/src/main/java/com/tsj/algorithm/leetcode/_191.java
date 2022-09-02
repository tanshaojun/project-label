package com.tsj.algorithm.leetcode;

/**
 * @Author tansj
 * @Date 2022/9/2 14:31
 * @Version 1.0
 */
public class _191 {

    /**
     * 191. 位1的个数
     * <p>
     * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res++;
//            n ^= ((~n + 1) & n);
            n &= (n - 1);
        }
        return res;
    }
}
