package com.tsj.algorithm.leetcode;

import com.tsj.algorithm.entities.TreeNode;

/**
 * @Author tansj
 * @Date 2022/8/29 09:38
 * @Version 1.0
 */
public class _998 {

    /**
     * 998. 最大二叉树 II
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode dump = new TreeNode(-1);
        dump.right = root;
        TreeNode head = dump;
        while (null != head && head.right != null) {
            if (head.right.val < val) {
                TreeNode right = head.right;
                TreeNode t = new TreeNode(val);
                head.right = t;
                t.left = right;
                return dump.right;
            }
            head = head.right;
        }
        head.right = new TreeNode(val);
        return dump.right;
    }

}
