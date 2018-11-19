package com.bill.learn.base.algorithm;

/**
 * 链表逆置：反转链表
 * Created by bill on 2018/11/15.
 */
public class ReverseListNode {
    /**
     * 测试
     * @param args a
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        ListNode node0 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node3.next = null;
        //ListNode node4 = new ListNode(4);
        //node4.next = null;

        head.next = node0;
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        //node3.next = node4;
        System.out.println("反转前");
        MyListNode.printListNode(head);
        System.out.println("*********中间结点***********");
        System.out.println(getMiddleNode(head).value);
        System.out.println();
        reverse(head);
        System.out.println("反转后");
        MyListNode.printListNode(head);
        System.out.println("*********中间结点***********");
        System.out.println(getMiddleNode(head).value);
    }

    /**
     * 链表翻转
     * @param head 链表头结点
     */
    public static void reverse(ListNode head) {
        //p:待逆置的链表 q是p中等待逆置的第一个元素
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
     * 获取链表的中间结点
     * 基数个：取中间那个
     * 偶数个：取前面那个
     * @param head 链表头结点
     * @return 中间结点
     */
    public static ListNode getMiddleNode(ListNode head) {
        if (head == null) {
            return head;
        }
        //快慢指针：fast走2步，slow走一步，fast == slow时，slow就是中间结点
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
