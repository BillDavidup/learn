package com.bill.learn.base.algorithm.list;

import com.bill.learn.base.algorithm.list.common.DoubleLinkedListNode;

/**
 * @author wudening
 * @description: 双向有序链表的测试
 * @date 2019-08-05 21:43
 */
public class DoubleLinkedListTest {

    public static void main(String[] args) {
        DoubleLinkedListNode head = DoubleLinkedLists.init();
        DoubleLinkedLists.printDoubleLinkedList(head);
        System.out.println("-------------------------------");
        DoubleLinkedLists.orderDelAll(head, 2);
        DoubleLinkedLists.printDoubleLinkedList(head);
        System.out.println("-------------------------------");

        DoubleLinkedListNode head2 = DoubleLinkedLists.initSimpleDoubleList();

        System.out.println("---------------插入前----------------");
        DoubleLinkedLists.printDoubleLinkedList(head2);
        System.out.println("---------------插入后----------------");
        DoubleLinkedLists.orderInsert(head2, 99);
        DoubleLinkedLists.printDoubleLinkedList(head2);

    }
}
