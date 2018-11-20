package com.bill.learn.base.algorithm.lru;

/**
 * 双向链表结点
 * Created by bill on 2018/11/21.
 */
public class Node {
    int key;
    int value;
    Node pre;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
