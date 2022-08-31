package com.tsj.algorithm.leetcode;

/**
 * @Author tansj
 * @Date 2022/8/29 09:38
 * @Version 1.0
 */
public class _946 {

    /**
     * 946. 验证栈序列
     * <p>
     * 给定pushed和popped两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false。
     *
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int slideIdx = -1;
        int pushIdx = 0;
        int popIdx = 0;
        while (pushIdx < pushed.length) {
            if (pushed[pushIdx] == popped[popIdx]) {
                pushIdx++;
                popIdx++;
                while (slideIdx != -1 && pushed[slideIdx] == popped[popIdx]) {
                    slideIdx--;
                    popIdx++;
                }
            } else {
                pushed[++slideIdx] = pushed[pushIdx++];
            }
        }
        return slideIdx == -1;
    }

}
