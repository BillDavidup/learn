package com.bill.learn.base.designmode;

/**
 * Created by bill on 2018/11/23.
 */
public class SingletonPattern {
    //私有化构造方法，不让new
    private SingletonPattern() {}

    public static volatile SingletonPattern singletonPattern = null;

    public static SingletonPattern getSingletonPattern() {
        if (singletonPattern == null) {
            synchronized(SingletonPattern.class) {
                if (singletonPattern == null) {
                    singletonPattern = new  SingletonPattern();
                }
            }
        }
        return singletonPattern;
    }
}
