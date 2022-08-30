package com.tsj.algorithm.code;

import com.tsj.algorithm.entities.Node;

/**
 * 反转单链表
 *
 * @Author tansj
 * @Date 2022/8/29 11:42
 * @Version 1.0
 */
public class ReverseNode {

    public Node reverseNode(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
