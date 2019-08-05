package com.bill.learn.base.algorithm.list;

import com.bill.learn.base.algorithm.list.common.DoubleLinkedListNode;

/**
 * @author wudening
 * @description: 双向链表工具类
 * @date 2019-08-05 21:37
 */
public class DoubleLinkedLists {
    /**
     * 双向有序链表的插入，从小到大的顺序
     *
     * @param head
     * @param val
     * @return
     */
    public static DoubleLinkedListNode orderInsert(DoubleLinkedListNode head, int val) {
        if (head == null) {
            return null;
        }
        DoubleLinkedListNode create = new DoubleLinkedListNode(val);
        if (head.next == null) {
            head.next = create;
            create.pre = head;
            return head;
        }
        DoubleLinkedListNode temp = head.next;
        while (temp != null) {
            //找到了,在temp的前驱节点后插入新节点
            if (val <= temp.val) {
                create.next = temp;
                create.pre = temp.pre;
                temp.pre.next = create;
                temp.pre = create;
                return head;
            } else if (val > temp.val && temp.next == null) {
                //尾节点插入
                temp.next = create;
                create.pre = temp;
                return head;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    /**
     * 双向有序链表的删除，从小到大的顺序,仅删找到的第一个
     *
     * @param head
     * @param val
     */
    public static void orderDel(DoubleLinkedListNode head, int val) {
        //查找到需要删除的节点，注意仅有头结点和找不到都返回null
        DoubleLinkedListNode pos = findDelPos(head, val);

        //没有找到待删除的节点
        if (pos == null) {
            return;
        }

        //删除的是尾节点
        if (pos.next == null) {
            pos.pre.next = null;
            pos.pre = null;
            return;
        }

        //非尾节点
        pos.next.pre = pos.pre;
        pos.pre.next = pos.next;
        pos.pre = null;
        pos.next = null;
        return;
    }

    /**
     * 双向有序链表的删除，从小到大的顺序,删除所有找到的节点
     *
     * @param head
     * @param val
     */
    public static void orderDelAll(DoubleLinkedListNode head, int val) {

        if (head == null || head.next == null) {
            return;
        }
        DoubleLinkedListNode temp = head.next;
        while (temp != null) {
            if (temp.val == val) {
                //找到了，删除该节点
                //如果删除的该节点是尾节点
                if (temp.next == null) {
                    //尾节点与前驱节点的指针断开
                    temp.pre.next = null;
                    //尾节点回收
                    temp.pre = null;
                    return;
                } else {
                    //删除的不是尾节点
                    DoubleLinkedListNode t = temp.next;
                    temp.next.pre = temp.pre;
                    temp.pre.next = temp.next;
                    //回收temp节点
                    temp.pre = null;
                    temp.next = null;
                    //继续查找下一个节点
                    temp = t;
                }
            } else {
                temp = temp.next;
            }
        }

    }

    public static DoubleLinkedListNode findDelPos(DoubleLinkedListNode head, int val) {
        if (head == null || head.next == null) {
            return null;
        }
        DoubleLinkedListNode temp = head.next;
        while (temp != null) {
            if (temp.val == val) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    /**
     * 双向有序链表的查找
     *
     * @param h
     * @param val
     * @return
     */
    public static DoubleLinkedListNode findDoubleListNode(DoubleLinkedListNode h, int val) {
        return null;
    }

    /**
     * 初始化一个有序递增链表，带有头结点，头结点的val不存值，默认0；
     *
     * @return
     */
    public static DoubleLinkedListNode init() {

        DoubleLinkedListNode head = new DoubleLinkedListNode();
        DoubleLinkedListNode first = new DoubleLinkedListNode(2);
        DoubleLinkedListNode second = new DoubleLinkedListNode(2);
        DoubleLinkedListNode third = new DoubleLinkedListNode(5);
        DoubleLinkedListNode four = new DoubleLinkedListNode(12);
        DoubleLinkedListNode five = new DoubleLinkedListNode(23);
        DoubleLinkedListNode six = new DoubleLinkedListNode(23);
        DoubleLinkedListNode seven = new DoubleLinkedListNode(55);
        DoubleLinkedListNode eight = new DoubleLinkedListNode(99);
        DoubleLinkedListNode nine = new DoubleLinkedListNode(99);


        head.pre = null;
        head.next = first;

        first.pre = head;
        first.next = second;

        second.pre = first;
        second.next = third;

        third.pre = second;
        third.next = four;

        four.pre = third;
        four.next = five;

        five.pre = four;
        five.next = six;

        six.pre = five;
        six.next = seven;

        seven.pre = six;
        seven.next = eight;

        eight.pre = seven;
        eight.next = nine;

        nine.pre = eight;
        nine.next = null;

        return head;
    }

    /**
     * 初始化一个简单双向递增链表
     * @return
     */
    public static DoubleLinkedListNode initSimpleDoubleList() {
        DoubleLinkedListNode head = new DoubleLinkedListNode();
        DoubleLinkedListNode one = new DoubleLinkedListNode(1);
        DoubleLinkedListNode two = new DoubleLinkedListNode(3);
        head.next = one;
        one.pre = head;
        two.pre = one;
        one.next = two;

        return head;
    }

    /**
     * 双向链表的打印
     * @param head
     */
    public static void printDoubleLinkedList(DoubleLinkedListNode head) {
        if (head == null || head.next == null) {
            System.out.println("head为null或者只有头结点");
            return;
        }
        DoubleLinkedListNode temp = head.next;
        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null) {
                System.out.print("->");
            } else {
                System.out.println();
            }
            temp = temp.next;
        }
    }

}
