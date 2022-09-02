package com.tsj.algorithm.entities;

/**
 * 前缀树
 *
 * @Author tansj
 * @Date 2022/9/2 15:57
 * @Version 1.0
 */
public class TrieTree {

    public TrieTreeNode root;

    public static class TrieTreeNode {
        public int pass;
        public int end;
        public TrieTreeNode[] next;


        public TrieTreeNode() {
            next = new TrieTreeNode[26];
        }
    }

    public TrieTree() {
        root = new TrieTreeNode();
    }

    public void insert(String word) {
        if (null == word) {
            return;
        }
        char[] chars = word.toCharArray();
        TrieTreeNode head = root;
        head.pass++;
        int idx;
        for (int i = 0; i < chars.length; i++) {
            idx = chars[i] - 'a';
            if (head.next[idx] == null) {
                head.next[idx] = new TrieTreeNode();
            }
            head.next[idx].pass++;
            head = head.next[idx];
        }
        head.end++;
    }

    public int find(String word) {
        if (null == word) {
            return 0;
        }
        char[] chars = word.toCharArray();
        TrieTreeNode head = root;
        int idx;
        for (int i = 0; i < chars.length; i++) {
            idx = chars[i] - 'a';
            if (head.next[idx] == null) {
                return 0;
            }
            head = head.next[idx];
        }
        return head.end;
    }

    public void delete(String word) {
        if (null == word) {
            return;
        }
        if (find(word) != 0) {
            char[] chars = word.toCharArray();
            TrieTreeNode head = root;
            head.pass--;
            int idx;
            for (int i = 0; i < chars.length; i++) {
                idx = chars[i] - 'a';
                if (--head.next[idx].pass == 0) {
                    head.next[idx] = null;
                    return;
                }
                head = head.next[idx];
            }
            head.end--;
        }
    }

}
