package com.bill.learn.base.algorithm.list;

/**
 * Created by bill on 2018/11/14.
 */
public class MyListNode {
    /**
     * 头插法
     * @param head      链表的头结点
     * @param newNode   待插入的节点
     */
    public static void headInsert(ListNode head, ListNode newNode) {
        newNode.next = head.next;
        head.next = newNode;
    }

    /**
     * 尾插法
     * @param tail      链表的尾结点
     * @param newNode   待插入的节点
     */
    public static void tailInsert(ListNode tail, ListNode newNode) {
        tail.next = newNode;
        tail = newNode;
    }

    public void testHeadInsert() {
        //头插法测试
        ListNode head = new ListNode();
        ListNode newNode = new ListNode(1);
        headInsert(head, newNode);
        ListNode newNode1 = new ListNode(2);
        headInsert(head, newNode1);
        printListNode(head);
    }

    public void testTailInsert() {
        //尾插法测试
        ListNode head = new ListNode();
        ListNode tempHead = head;
        ListNode newNode = new ListNode(1);
        tailInsert(tempHead, newNode);
        ListNode newNode1 = new ListNode(2);
        tailInsert(tempHead, newNode1);
        printListNode(head);
    }

    /**
     * 遍历链表
     * @param head 待遍历链表的头结点
     */
    public static void printListNode(ListNode head) {
        while (head.next != null) {
            head = head.next;
            System.out.print(head.value + " ");
        }
    }

    /**
     * 查找链表中第一个的值，返回结点位置，
     * @param head 头结点
     * @param value 值
     * @return 值在链表的位置，没找到返回-1
     */
    public static int find(ListNode head, int value) {
        int index = -1;
        int count = 0;
        while (head != null) {
            if (head.value == value) {
                index = count;
                return index;
            }
            count++;
            head = head.next;
        }
        return index;
    }

    /**
     * 在p结点后插入s结点
     * @param p 待插入结点后的位置
     * @param s 需要插入的结点
     */
    public static void insert(ListNode p, ListNode s) {
        //保存下p结点后的结点q
        ListNode q = p.next;
        //将s结点的next指向p结点后的结点q
        s.next = q;
        //p结点指向待插入的结点s
        p.next = s;
    }

    /**
     * 删除链表中的q结点
     * 提示：将q结点的下一个结点p的数据复制到q结点，q结点的next指针指向p结点的下一个结点,再把q的下一个结点删除掉
     * @param head      链表的头结点
     * @param q         等待删除的节点
     */
    public static void delete(ListNode head, ListNode q) {
        if (q != null && q.next != null) {
            //用p保存q结点的下一个结点
            ListNode p = q.next;
            //把q结点的下一个结点p的值保存到q结点
            q.value = p.value;
            //删除掉q.next
            q.next = p.next;
            //释放p,p赋值为null,GC回收
            p = null;
        }
        //删除最后一个元素的情况:最后一个元素的next值为null;
        if (q.next == null) {
            while (head != null) {
                if (head.next != null && head.next == q) {
                    head.next = null;
                    break;
                }
                head = head.next;
            }
        }
    }
}
