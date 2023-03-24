package com.tsj.algorithm.leetcode;

/**
 * @Author tansj
 * @Date 2022/9/7 09:38
 * @Version 1.0
 */
public class _1592 {


    /**
     * 1592. 重新排列单词间的空格
     * <p>
     * 给你一个字符串 text ，该字符串由若干被空格包围的单词组成。每个单词由一个或者多个小写英文字母组成，并且两个单词之间至少存在一个空格。题目测试用例保证 text 至少包含一个单词 。
     * 请你重新排列空格，使每对相邻单词之间的空格数目都 相等 ，并尽可能 最大化 该数目。如果不能重新平均分配所有空格，请 将多余的空格放置在字符串末尾 ，这也意味着返回的字符串应当与原 text 字符串的长度相等。
     * 返回 重新排列空格后的字符串 。
     *
     * @param text
     * @return
     */
    public String reorderSpaces(String text) {
        char[] chars = text.toCharArray();
        int spaceCount = 0;
        for (char c : chars) {
            if (c == ' ') {
                spaceCount++;
            }
        }
        if (spaceCount == 0) {
            return text;
        }
        int wordCount = 0, aa = 0, bb;
        String[] s = text.split(" ");
        for (String s1 : s) {
            if (!"".equals(s1)) {
                wordCount++;
            }
        }
        if (wordCount > 1) {
            aa = spaceCount / (wordCount - 1);
            bb = spaceCount % (wordCount - 1);
        } else {
            bb = spaceCount;
        }
        String a = "", res = "";
        while (aa-- > 0) {
            a += " ";
        }
        for (int i = 0; i < s.length; i++) {
            if (!"".equals(s[i])) {
                res += s[i];
                if (i != s.length - 1) {
                    res += a;
                }
            }
        }
        while (bb-- > 0) {
            res += " ";
        }
        return res;
    }
}
