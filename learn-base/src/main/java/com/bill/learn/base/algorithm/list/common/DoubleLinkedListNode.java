package com.bill.learn.base.algorithm.list.common;

/**
 * @author wudening
 * @description: 双向链表整形值节点
 * @date 2019-08-05 21:32
 */
public class DoubleLinkedListNode {
    public DoubleLinkedListNode pre;
    public DoubleLinkedListNode next;
    public int val;

    public DoubleLinkedListNode() {
    }

    public DoubleLinkedListNode(int val) {
        this.val = val;
    }
}
