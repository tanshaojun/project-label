package com.tsj.algorithm.leetcode;

/**
 * @Author tansj
 * @Date 2022/9/9 10:01
 * @Version 1.0
 */
public class _1598 {

    /**
     * 1598. 文件夹操作日志搜集器
     *
     * @param logs
     * @return
     */
    public int minOperations(String[] logs) {
        int res = 0;
        for (String log : logs) {
            if ("./".equals(log)) {

            } else if ("../".equals(log)) {
                if (res > 0) {
                    res--;
                }
            } else {
                res++;
            }
        }
        return res;
    }

}
