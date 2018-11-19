package com.bill.learn.base.algorithm.stack;

import com.bill.learn.base.algorithm.list.ListNode;

/**
 * 基于链表实现的栈
 * Created by bill on 2018/11/20.
 */
public class MyStack {
    public ListNode top;
    public ListNode bottom;

    /**
     * 栈构造方法
     */
    public MyStack(ListNode top, ListNode bottom) {
        this.top = top;
        this.bottom = bottom;
    }

    /**
     * 进栈
     * @param mystack   操作的栈
     * @param value 入栈的值
     */
    public static void push(MyStack mystack, int value) {
        ListNode node = new ListNode(value);
        node.next = mystack.top;
        mystack.top = node;
    }

    /**
     * 遍历
     * 栈顶元素指针不指向栈底
     */
    public static void traverse(MyStack myStack) {
        ListNode top = myStack.top;
        while (top != myStack.bottom) {
            System.out.print(top.value + " ");
            top = top.next;
        }
    }

    /**
     * 判断栈是否为空
     * @param myStack   操作的栈
     * @return 是否空
     */
    public static boolean isEmpty(MyStack myStack) {
        if (myStack.top == myStack.bottom) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 出栈
     * @param myStack 操作的栈
     */
    public static void pop(MyStack myStack) {
        if (!isEmpty(myStack)) {
            ListNode top = myStack.top;
            myStack.top = top.next;
            System.out.println(top.value);
        }
    }

    /**
     * 清空栈
     * @param myStack 操作的栈
     */
    public static void clear(MyStack myStack) {
        myStack.top = null;
        myStack.bottom = null;
    }

    /**
     * 测试
     * @param args a
     */
    public static void main(String[] args) {
        MyStack myStack = new MyStack(new ListNode(0), new ListNode(0));
        myStack.bottom = myStack.top;

        System.out.println(isEmpty(myStack));
        myStack.push(myStack, 1);
        myStack.push(myStack, 2);
        myStack.push(myStack, 3);
        traverse(myStack);
        System.out.println(isEmpty(myStack));
        pop(myStack);
        clear(myStack);
        System.out.println(isEmpty(myStack));
    }
}
