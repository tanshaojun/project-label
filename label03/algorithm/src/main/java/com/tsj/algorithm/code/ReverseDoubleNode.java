package com.tsj.algorithm.code;

import com.tsj.algorithm.entities.DoubleNode;

/**
 * 反转双向链表
 *
 * @Author tansj
 * @Date 2022/8/29 11:42
 * @Version 1.0
 */
public class ReverseDoubleNode {

    public DoubleNode reverseDoubleNode(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }

}
