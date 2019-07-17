package com.bill.learn.base.lock.synchronize;

/**
 * @author wudening
 * @description: Synchronized关键字可重入研究
 * @date 2019-07-16 23:06
 */
public class SynchronizedReentrant {

    private Object obj = new Object();

    public synchronized void saySomething() {
        System.out.println("saySomething-sync:");
    }

    /**
     * 可重入方法
     */
    public synchronized void doSomething() {

        //同一个对象锁可重入
        saySomething();
        System.out.println("doSomething-sync:");

    }

    /**
     * 不可重入方法
     */
    public void goSomewhere() {

        synchronized (obj) {
            //对象不一致不能重入
            saySomething();
            doSomething();
            System.out.println("goSomewhere-sync:");
        }

    }
}
