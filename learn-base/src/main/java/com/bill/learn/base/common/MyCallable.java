package com.bill.learn.base.common;

import java.util.concurrent.Callable;

/**
 * 带有返回值得线程类
 * Created by bill on 2018/11/5.
 */
public class MyCallable implements Callable<Integer>{
    String str;
    public MyCallable(String str) {
        this.str = str;
    }
    @Override
    public Integer call() throws Exception {
        System.out.println("call is executing:" + str + ",Thread:" + Thread.currentThread().getName());
        //TimeUnit.SECONDS.sleep(1);
        return 9;
    }
}
