package com.tsj.algorithm.leetcode;

import com.tsj.algorithm.entities.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author tansj
 * @Date 2022/9/5 10:00
 * @Version 1.0
 */
public class _652 {

    List<TreeNode> res = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();

    /**
     * 652. 寻找重复的子树
     * <p>
     * 给定一棵二叉树 root，返回所有重复的子树。
     * 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
     * 如果两棵树具有相同的结构和相同的结点值，则它们是重复的。
     *
     * @param root
     * @return
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return res;
    }

    /**
     * 递归+序列化+hash表
     *
     * @param root
     * @return
     */
    private String dfs(TreeNode root) {
        if (null == root) {
            return "#";
        }
        String str = root.val + "," + dfs(root.left) + "," + dfs(root.right);
        int count = map.getOrDefault(str, 0);
        if (count == 1) {
            res.add(root);
        }
        map.put(str, count + 1);
        return str;
    }
}
