package com.bill.learn.base.algorithm.list;

/**
 * @author wudening
 * @description: 链表工具类
 * @date 2019-08-04 11:06
 */
public class ListTools {

    static ListNode node6 = new ListNode(6);
    static ListNode node7 = new ListNode(7);

    //公共节点第一个链表
    public static ListNode initFirstList() {
        ListNode rootFirst = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        rootFirst.next = node2;
        node2.next = node3;
        node3.next = node6;
        node6.next = node7;
        return rootFirst;
    }

    //公共节点第二个链表
    public static ListNode initSecondList() {
        ListNode rootSecond = new ListNode(4);
        ListNode node5 = new ListNode(5);
        rootSecond.next = node5;
        node5.next = node6;
        return rootSecond;
    }

}
