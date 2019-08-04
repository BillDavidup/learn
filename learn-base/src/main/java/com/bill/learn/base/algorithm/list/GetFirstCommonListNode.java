package com.bill.learn.base.algorithm.list;

/**
 * @author wudening
 * @description: 获取链表的第一个公共节点，https://blog.csdn.net/kongmin_123/article/details/82315013
 * @date 2019-08-04 11:15
 */
public class GetFirstCommonListNode {

    /**
     * 获取两链表中第一个公共节点，比较的是节点的引用，不是值
     * @param first 第一个链表
     * @param second 第二个链表
     * @return 公共节点
     */
    public static ListNode getFirstCommonListNode(ListNode first, ListNode second) {
        int count1 = 0;
        int count2 = 0;
        ListNode tNode1 = first;
        ListNode tNode2 = second;
        //分别遍历两个链表，获得链表长度
        while (tNode1 != null) {
            count1++;
            tNode1 = tNode1.next;
        }
        while (tNode2 != null) {
            count2++;
            tNode2 = tNode2.next;
        }
        //长的链表先走差值的长度
        int sub = count1 >= count2 ? count1 - count2 : count2 - count1;
        tNode1 = first;
        tNode2 = second;
        if (count1 >= count2) {
            for (int i = 0; i < sub; i++) {
                tNode1 = tNode1.next;
            }
        } else {
            for (int j = 0; j < sub; j++) {
                tNode2 = tNode2.next;
            }
        }

        //同时遍历两个链表，第一个相同的的节点就是他们公共的节点
        while (tNode1 != null && tNode2 != null) {
            if (tNode1 != tNode2) {
                tNode1 = tNode1.next;
                tNode2 = tNode2.next;
            } else {
                return tNode1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode first = ListTools.initFirstList();
        ListNode second = ListTools.initSecondList();
        ListNode firstComNode = getFirstCommonListNode(first, second);
        System.out.println("第一个公共节点是：" + firstComNode.value);
    }
}
