package com.bill.learn.base.algorithm.queue;

/**
 * 基于数组实现的队列
 * Created by bill on 2018/11/20.
 */
public class MyQueue {
    public int[] arrays;
    public int front;   //指向是第一个有效元素
    public int rear;    //指向的是最后一个有效元素的下一个元素（无效元素）

    /**
     * 构造方法
     * @param arrays 内部数组
     * @param front 队首指针
     * @param rear  队尾指针
     */
    public MyQueue(int[] arrays, int front, int rear) {
        this.arrays = arrays;
        this.front = front;
        this.rear = rear;
    }

    /**
     * 判断栈满
     * @param myQueue 操作的队列
     * @return 是否栈满
     */
    public static boolean isFull(MyQueue myQueue) {
        if ((myQueue.rear + 1) % myQueue.arrays.length == myQueue.front) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断栈空
     * @param myQueue 操作的队列
     * @return 是否栈空
     */
    public static boolean isEmpty(MyQueue myQueue) {
        if (myQueue.rear == myQueue.front) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 入队
     * @param myQueue 操作的队列
     * @param value 进队的值
     */
    public static void enQueue(MyQueue myQueue, int value) {
        if (!isFull(myQueue)) {
            myQueue.arrays[myQueue.rear] = value;
            myQueue.rear = (myQueue.rear + 1) % myQueue.arrays.length;
        }
    }

    /**
     * 遍历队列
     */
    public static void traverse(MyQueue myQueue) {
        int i = myQueue.front;

        while (i != myQueue.rear) {
            System.out.println(myQueue.arrays[i] + " ");
            i = (i + 1) % myQueue.arrays.length;
        }
        System.out.println();
    }

    /**
     * 出队
     */
    public static void outQueue(MyQueue myQueue) {
        if (!isEmpty(myQueue)) {
            int value = myQueue.arrays[myQueue.front];
            System.out.println(value);
            myQueue.front = (myQueue.front + 1) % myQueue.arrays.length;
        }
    }

    /**
     * 测试
     * @param args a
     */
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(new int[6],0, 0);
        System.out.println(isEmpty(myQueue));

        enQueue(myQueue, 1);
        enQueue(myQueue, 2);
        enQueue(myQueue, 3);
        enQueue(myQueue, 4);
        enQueue(myQueue, 5);

        System.out.println(isFull(myQueue));

        traverse(myQueue);

        outQueue(myQueue);
    }

}
