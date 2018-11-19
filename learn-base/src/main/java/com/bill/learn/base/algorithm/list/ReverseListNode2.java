package com.bill.learn.base.algorithm.list;

/**
 * 一个链表，奇数位升序，偶数位降序，对该链表进行排序
 * 原链表：1 8 3 6 5 4 7 2 9
 * 排序后：1 2 3 4 5 6 7 8 9
 * Created by bill on 2018/11/19.
 */
public class ReverseListNode2 {

    /**
     *
     * @param head 链表头结点
     * @return 拆分的链表数组
     */
    public static ListNode[] splitLists(ListNode head) {
        ListNode head1 = null;
        ListNode head2 = null;

        ListNode cur1 = null;
        ListNode cur2 = null;

        int count = 1; //计数

        while (head != null) {
            if (count % 2 == 1) {
                if (cur1 != null) {
                    cur1.next = head;
                    cur1 = cur1.next;
                } else {
                    cur1 = head;
                    head1 = cur1;
                }
            } else {
                if (cur2 != null) {
                    cur2.next = head;
                    cur2 = cur2.next;
                } else {
                    cur2 = head;
                    head2 = cur2;
                }
            }
            head = head.next;
            count ++;
        }
        cur1.next = null;
        cur2.next = null;

        ListNode[] nodes = new ListNode[] {head1, head2};
        return nodes;
    }

    /**
     *
     * @param head 链表头结点
     */
    public static void reverseList(ListNode head) {
        ListNode p;
        ListNode q;
        p = head.next;
        head.next = null;
        while (p != null) {
            q = p;
            p = p.next;
            q.next = head.next;
            head.next = q;
        }
    }

    /**
     *
     * @param head 链表头结点
     * @return 翻转后的链表
     */
    public static ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     *
     * @param head1 第一个链表
     * @param head2 第二个链表
     * @return 合并后的链表
     */
    public static ListNode mergeTwoList(ListNode head1, ListNode head2) {
        if (head1 == null & head2 == null) {
            return null;
        }
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode head = null;
        if (head1.value > head2.value) {
            head = head2;
            head.next = mergeTwoList(head1, head2.next);
        } else {
            head = head1;
            head.next = mergeTwoList(head1.next, head2);
        }
        return head;
    }

    /**
     *
     * @return
     */
    public static ListNode init() {
        ListNode node = new ListNode(0);

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(2);
        ListNode node9 = new ListNode(9);
        node9.next = null;

        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;

        return node1;
    }

    /**
     * 测试
     * @param args a
     */
    public static void main(String[] args) {
        ListNode head = init();
        ListNode[] lists = splitLists(head);

        ListNode head1 = lists[0];
        ListNode head2 = lists[1];

        head2 = reverseList2(head2);

        head = mergeTwoList(head1, head2);

        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}
