package com.bill.learn.base.algorithm;

/**
 * LeedCode:148
 * 链表的归并排序
 * Created by bill on 2018/11/19.
 */
public class MergeSortListNode {

    /**
     *
     * @param head 头结点
     * @return 排序后的链表
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode right = mid.next;
        mid.next = null;    //咬断链表
        ListNode node  = merge(sortList(head), sortList(right));
        return node;
    }

    /**
     *
     * @param head 头结点
     * @return 链表中间结点，偶数个为第一个
     */
    public ListNode getMid(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    /**
     * 将两个有序链表合并为一个有序链表（非递归方式）
     * @param head1 作为基准的链表1
     * @param head2 需要合并到基准链表1的链表2
     * @return
     */
    public ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 != null ? head1 : head2;
        }

        ListNode head = head1.value < head2.value ? head1 : head2;

        ListNode cur1 = head == head1 ? head1 : head2;
        ListNode cur2 = head == head2 ? head2 : head1;

        ListNode pre = null;    //cur1的上一个结点
        ListNode next = null;   //cur2的下一个结点

        while (cur1 != null && cur2 != null) {
            if (cur1.value <= cur2.value) {
                pre = cur1;
                cur1 = cur1.next;
            } else {
                next = cur2.next;
                pre.next = cur2;
                cur2.next = cur1;
                pre = cur2;
                cur2 = next;
            }
        }
        pre.next = cur1 == null ? cur2 : cur1;
        return head;
    }
}
