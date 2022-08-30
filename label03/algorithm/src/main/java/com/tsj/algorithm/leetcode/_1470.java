package com.tsj.algorithm.leetcode;

/**
 * @Author tansj
 * @Date 2022/8/29 09:38
 * @Version 1.0
 */
public class _1470 {

    /**
     * 1470. 重新排列数组
     * <p>
     * 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
     * <p>
     * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
     *
     * @param nums
     * @param n
     * @return
     */
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        int idx = -1;
        for (int i = 0; i < n; i++) {
            res[++idx] = nums[i];
            res[++idx] = nums[i + n];
        }
        return res;
    }

}
