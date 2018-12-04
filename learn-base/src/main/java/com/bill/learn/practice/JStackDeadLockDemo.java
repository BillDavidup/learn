package com.bill.learn.practice;

/**
 * 死锁分析
 * Created by bill on 2018/12/4.
 */
public class JStackDeadLockDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(new DeadLockTest(true));
        Thread t2 = new Thread(new DeadLockTest(false));
        t1.setName("seckill-1");
        t2.setName("seckill-2");
        t1.start();
        t2.start();
    }
}

class DeadLockTest implements Runnable {
    //控制线程执行代码块
    public boolean flag;

    public DeadLockTest(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            //T1线程
            while (true) {
                synchronized (ObjectInstance.o1) {
                    System.out.println("o1 " + Thread.currentThread().getName());
                    synchronized (ObjectInstance.o2) {
                        System.out.println("o2 " + Thread.currentThread().getName());
                    }
                }
            }
        } else {
            //T2线程
            synchronized (ObjectInstance.o2) {
                System.out.println("o2 " + Thread.currentThread().getName());
                synchronized (ObjectInstance.o1) {
                    System.out.println("o1 " + Thread.currentThread().getName());
                }
            }
        }

    }
}

class ObjectInstance {
    static Object o1 = new Object();
    static Object o2 = new Object();
}
