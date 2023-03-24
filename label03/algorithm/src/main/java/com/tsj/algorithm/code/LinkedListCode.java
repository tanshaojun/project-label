package com.tsj.algorithm.code;

import com.tsj.algorithm.entities.Node;

import java.util.Stack;

/**
 * @Author tansj
 * @Date 2022/9/5 11:08
 * @Version 1.0
 */
public class LinkedListCode {

    /**
     * 输入链表头节点，奇数长度返回中点，偶数长度返回上中点
     */
    public Node code(Node root) {
        if (null == root || null == root.next || null == root.next.next) {
            return root;
        }
        Node slow = root.next;
        Node fast = root.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 输入链表头节点，奇数长度返回中点，偶数长度返回下中点
     */
    public Node code1(Node root) {
        if (null == root || null == root.next) {
            return root;
        }
        Node slow = root.next;
        Node fast = root.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 输入链表头节点，奇数长度返回中点前一个，偶数长度返回上中点前一个
     */
    public Node code2(Node root) {
        if (null == root || null == root.next || null == root.next.next) {
            return null;
        }
        Node slow = root;
        Node fast = root.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 输入链表头节点，奇数长度返回中点前一个，偶数长度返回下中点前一个
     */
    public Node code3(Node root) {
        if (null == root || null == root.next) {
            return null;
        }
        if (null == root.next.next) {
            return root;
        }
        Node slow = root;
        Node fast = root.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 判断链表是不是回文
     *
     * @param root
     * @return
     */
    public boolean code4(Node root) {
        Stack<Node> stack = new Stack<>();
        Node head = root;
        while (null != head) {
            stack.push(head);
            head = head.next;
        }
        head = root;
        while (null != head && stack.pop().val == head.val) {
            head = head.next;
        }
        return null == head;
    }

    /**
     * 判断链表是不是回文
     *
     * @param root
     * @return
     */
    public boolean code5(Node root) {
        if (null == root || null == root.next) {
            return true;
        }
        Node slow = root;
        Node fast = root;
        //找到中点slow
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //将后半段链表反转
        fast = slow.next;
        slow.next = null;
        while (fast != null) {
            Node next = fast.next;
            fast.next = slow;
            slow = fast;
            fast = next;
        }
        //判断是否回文
        Node head = root;
        fast = slow;
        boolean flags = true;
        while (flags && null != slow && null != head) {
            if (slow.val != head.val) {
                flags = false;
            }
            slow = slow.next;
            head = head.next;
        }
        //将后半段还原
        head = fast.next;
        fast.next = null;
        while (head != null) {
            Node next = head.next;
            head.next = fast;
            fast = head;
            head = next;
        }
        return flags;
    }

}
