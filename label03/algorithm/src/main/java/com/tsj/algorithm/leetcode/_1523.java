package com.tsj.algorithm.leetcode;

/**
 * @Author tansj
 * @Date 2022/9/2 14:17
 * @Version 1.0
 */
public class _1523 {


    /**
     * 1523. 在区间范围内统计奇数数目
     * <p>
     * 给你两个非负整数 low 和 high 。请你返回 low 和 high 之间（包括二者）奇数的数目。
     * <p>
     * <p>
     *
     * @param low
     * @param high
     * @return
     */
    public int countOdds(int low, int high) {
        if (low % 2 == 0 && high % 2 == 0)
            return (high - low) / 2;
        return (high - low) / 2 + 1;
    }

}
