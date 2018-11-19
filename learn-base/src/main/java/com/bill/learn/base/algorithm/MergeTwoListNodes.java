package com.bill.learn.base.algorithm;

import java.util.List;

/**
 * 合并两个有序链表：
 * Created by bill on 2018/11/15.
 */
public class MergeTwoListNodes {
    /**
     * 测试
     * @param args a
     */
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node3;
        node2.next = node4;

        ListNode listNode = mergeTwoList1(node1, node2);

        while (listNode != null) {
            System.out.print(listNode.value + " ");
            listNode = listNode.next;
        }
    }

    /**
     * 递归求有2个有序链表的合并
     * @param head1 待合并的第一个链表
     * @param head2 待合并的第二个链表
     * @return 合并后链表的头结点
     */
    public static ListNode mergeTwoList(ListNode head1, ListNode head2) {
        //结束条件
        if (head1 == null && head2 == null) {
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
     * 非递归：首节点值小的链表作为最终返回的结果
     * @param head1 待合并的第一个链表
     * @param head2 待合并的第二个链表
     * @return
     */
    public static ListNode mergeTwoList1(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 != null ? head1 : head2;
        }
        //找到头结点值较小的链表，另一个链表合并到较小链表上
        ListNode head = head1.value < head2.value ? head1 : head2;
        //cur1是头结点值较小的链表，作为基准
        ListNode cur1 = head == head1 ? head1 : head2;
        ListNode cur2 = head == head1 ? head2 : head1;

        ListNode pre = null;    //cur1前一个元素
        ListNode next = null;   //cur2后一个元素

        while (cur1 != null && cur2 != null) {
            if (cur1.value <= cur2.value) {
                pre = cur1;
                cur1 = cur1.next;
            } else {
                //插入
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
