package com.bill.learn.base.algorithm.queue;

import java.util.Stack;

/**
 * Created by bill on 2018/11/20.
 */
public class TwoStackOneQueue {
    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    /**
     * 构造
     */
    public TwoStackOneQueue(Stack<Integer> stackPush, Stack<Integer> stackPop) {
        this.stackPush = stackPush;
        this.stackPop = stackPop;
    }

    public void add(int value) {
        stackPush.push(value);
    }

    /**
     * 取出队首元素，并去除
     * @return
     */
    public int poll() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        } else if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    /**
     * 取出队首元素，不去除
     * @return
     */
    public int peek() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        } else if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

    /**
     * 测试
     * @param args a
     */
    public static void main(String[] args) {
        TwoStackOneQueue queue = new TwoStackOneQueue(new Stack<Integer>(),new Stack<Integer>());

        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.peek());


    }

}
