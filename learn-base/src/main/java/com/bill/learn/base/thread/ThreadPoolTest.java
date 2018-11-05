package com.bill.learn.base.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by bill on 2018/11/1.
 */
public class ThreadPoolTest {

    //自定义线程工程：目的是修改了线程的标识为seckill,方便dump分析
    static class MyThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        public MyThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            namePrefix = "Seckill-"
                    + poolNumber.getAndIncrement()
                    + "-thread-";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
            return t;
        }

    }

    //自定义一个任务线程
    static class MyRunnableTask implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 1; i++) {
                System.out.println(Thread.currentThread().getName() + ",i=" + i);
            }
        }
    }

    /**
     * 线程池使用
     * @param args a
     * @throws Exception e
     */
    public static void main(String[] args) throws Exception {
        //创建自定义线程工厂的一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(2, new MyThreadFactory());
        ThreadPoolExecutor pools = new ThreadPoolExecutor(
                1,10, 1, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10),
                new MyThreadFactory());

        //设置pools饱和策略
        pools.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());


        for (int i = 0; i < 20; i++) {
            pool.submit(new MyRunnableTask());
        }
        pool.shutdown();

        Thread.sleep(1000);
        System.out.println("------------");

        for (int i = 0; i < 2000; i++) {
            pools.submit(new MyRunnableTask());
        }
        pools.shutdown();

    }
}

