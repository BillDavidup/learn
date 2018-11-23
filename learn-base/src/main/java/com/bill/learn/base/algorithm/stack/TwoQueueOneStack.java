package com.bill.learn.base.algorithm.stack;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 用两个队列实现栈
 * Created by bill on 2018/11/23.
 */
public class TwoQueueOneStack {
    Queue q1 = new ArrayDeque<Integer>();
    Queue q2 = new ArrayDeque<Integer>();

    /**
     * 判断栈空
     * @return 是否栈空
     */
    public boolean isEmpty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    /**
     * 入栈
     * @param value
     */
    public synchronized void push(int value) {
        q1.add(value);
    }

    /**
     * 出栈
     * @return 出栈元素
     */
    public synchronized  int pop() {

        if (q1.size() == 1) {
            return (Integer) q1.poll();
        } else {
            while (q1.size() != 1) {
                q2.offer(q1.poll());
            }
            int tem = (int) q1.poll();
            while (!q2.isEmpty()) {
                q1.offer(q2.poll());
            }
            return tem;
        }
    }

    /**
     * 测试
     * @param args a
     */
    public static void main(String[] args) {

        TwoQueueOneStack stack = new TwoQueueOneStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();

    }
}
