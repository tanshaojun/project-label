package com.tsj.algorithm.leetcode;

import java.util.Arrays;

/**
 * @Author tansj
 * @Date 2022/9/3 10:39
 * @Version 1.0
 */
public class _646 {


    /**
     * 646. 最长数对链
     * <p>
     * 给出n个数对。在每一个数对中，第一个数字总是比第二个数字小。
     * 现在，我们定义一种跟随关系，当且仅当b < c时，数对(c, d)才可以跟在(a, b)后面。我们用这种形式来构造一个数对链。
     * 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
     *
     * @param pairs
     * @return
     */
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int res = 1, tmp = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > tmp) {
                res++;
                tmp = pairs[i][1];
            }
        }
        return res;
    }

}
