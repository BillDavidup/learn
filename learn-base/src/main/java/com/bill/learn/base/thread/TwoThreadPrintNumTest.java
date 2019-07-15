package com.bill.learn.base.thread;

/**
 * @author wudening
 * @description: 通过类对象锁，两线程交替输出奇偶数
 * @date 2019-07-15 21:50
 */
public class TwoThreadPrintNumTest {

    //输出奇偶数任务
    static class PrintTask implements Runnable {
        //必须是静态变量,jdk8前存放在方法区，jdk8及后存放在堆中，类共享
        static int num;

        @Override
        public void run() {
            while (num <= 100) {
                //临界区，持有同一把类对象锁PrintTask.class
                synchronized (PrintTask.class) {
                    System.out.println(Thread.currentThread().getName() + "-" + num);
                    num ++;
                    this.getClass().notify();
                    try {
                        PrintTask.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 测试main方法
     * @param args args
     */
    public static void main(String[] args) {
        new Thread(new PrintTask(),"偶数线程A").start();
        new Thread(new PrintTask(), "基数线程B").start();
    }
}
