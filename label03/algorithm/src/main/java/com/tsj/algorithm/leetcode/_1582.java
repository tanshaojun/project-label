package com.tsj.algorithm.leetcode;

/**
 * @Author tansj
 * @Date 2022/9/5 09:45
 * @Version 1.0
 */
public class _1582 {


    /**
     * 1582. 二进制矩阵中的特殊位置
     * <p>
     * <p>
     * 给你一个大小为 rows x cols 的矩阵 mat，其中 mat[i][j] 是 0 或 1，请返回 矩阵mat 中特殊位置的数目 。
     * 特殊位置 定义：如果 mat[i][j] == 1 并且第 i 行和第 j 列中的所有其他元素均为 0（行和列的下标均 从 0 开始 ），则位置 (i, j) 被称为特殊位置。
     *
     * @param mat
     * @return
     */
    public int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] rowsSum = new int[m];
        int[] colsSum = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowsSum[i] += mat[i][j];
                colsSum[j] += mat[i][j];
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && rowsSum[i] == 1 && colsSum[j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }
}
