package com.bill.learn.base.lock.synchronize;

/**
 * @author wudening
 * @description: SynchronizedReentrant的测试类
 * @date 2019-07-16 23:13
 */
public class SynchronizedReentrantTest {
    public static void main(String[] args) {
        SynchronizedReentrant sync = new SynchronizedReentrant();
        sync.doSomething();
        sync.saySomething();
        sync.goSomewhere();
    }
}
