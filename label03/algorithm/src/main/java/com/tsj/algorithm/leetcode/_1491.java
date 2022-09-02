package com.tsj.algorithm.leetcode;

/**
 * @Author tansj
 * @Date 2022/9/2 14:26
 * @Version 1.0
 */
public class _1491 {

    /**
     * 1491. 去掉最低工资和最高工资后的工资平均值
     * <p>
     * 给你一个整数数组 salary ，数组里每个数都是 唯一 的，其中 salary[i] 是第 i 个员工的工资。
     * <p>
     * 请你返回去掉最低工资和最高工资以后，剩下员工工资的平均值。
     *
     * @param salary
     * @return
     */
    public double average(int[] salary) {
        double min = Integer.MAX_VALUE;
        double max = Integer.MIN_VALUE;
        double sum = 0;
        for (int i : salary) {
            sum += i;
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        sum -= max;
        sum -= min;
        return sum / (salary.length - 2);
    }
}
