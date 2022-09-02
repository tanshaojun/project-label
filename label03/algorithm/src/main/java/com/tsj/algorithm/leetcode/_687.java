package com.tsj.algorithm.leetcode;

import com.tsj.algorithm.entities.TreeNode;

/**
 * @Author tansj
 * @Date 2022/9/2 09:17
 * @Version 1.0
 */
public class _687 {

    int max = 0;

    /**
     * 687. 最长同值路径
     * <p>
     * 给定一个二叉树的 root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。 这条路径可以经过也可以不经过根节点。
     * 两个节点之间的路径长度 由它们之间的边数表示。aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
     *
     * @param root
     * @return
     */
    public int longestUnivaluePath(TreeNode root) {
        process(root);
        return max;
    }

    public int process(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = process(root.left), right = process(root.right), left1 = 0, right1 = 0;
        if (root.left != null && root.left.val == root.val) {
            left1 = left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            right1 = right + 1;
        }
        max = Math.max(max, left1 + right1);
        return Math.max(left1, right1);
    }

}
