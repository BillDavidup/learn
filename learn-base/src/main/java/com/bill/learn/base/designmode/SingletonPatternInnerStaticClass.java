package com.bill.learn.base.designmode;

/**
 * 静态内部类实现单例
 * 借助类的加载机制
 * Created by bill on 2018/11/23.
 */
public class SingletonPatternInnerStaticClass {
    private SingletonPatternInnerStaticClass() {}

    private static class Singleton {
        private static final Singleton INSTANCE =  new Singleton();
    }
    //需要实例化的时候才调用getInstance Singleton类的实例化
    public static Singleton getInstance() {
        return Singleton.INSTANCE;
    }
}
