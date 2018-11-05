package com.bill.learn.base.thread;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by bill on 2018/11/2.
 */
public class CreateTraditionalThreadTest {

    /**
     * main主方法
     * @param args 参数
     */
    public static void main(String[] args) {
        Thread currentThread = Thread.currentThread();
        System.out.println("threadId:" + currentThread.getId() + ",threadName:" + currentThread.getName());
    }

    //方式一：实现Runable接口的run方法
    @Test
    public void testCreateThreadByImplRunnable() {

        //1.创建实现Runnable接口的类
        class MyRunnable implements Runnable {
            @Override
            public void run() {
                System.out.println("实现Runnable接口的run方法启动一个线程");
                Thread currentThread = Thread.currentThread();
                //输出该线程信息
                System.out.println("implThreadId:" + currentThread.getId() + ",threadName:" + currentThread.getName());
            }
        }

        //2.创建一个类对象
        Runnable myRunnable = new MyRunnable();

        //3.创建一个Thread，构造方法传入Runnable对象
        Thread myTread = new Thread(myRunnable);

        //4.启动一个线程
        myTread.start();
    }

    //方式二：继承Thread类
    @Test
    public void testCreateThreadByExtendsThread() {

        //1.定义一个继承Thread的类来创建一个线程
        class MyThread extends Thread {
            public void run() {
                System.out.println("继承Thread类重写run方法启动一个线程");
                Thread currentThread = Thread.currentThread();
                //输出该线程信息
                System.out.println("extendsThreadId:"
                        + currentThread.getId()
                        + ",threadName1:"
                        + currentThread.getName());
            }
        }

        //2.构造子类的一个对象
        MyThread myThread = new MyThread();

        //3.启动线程
        myThread.start();
    }

    //方式三：实现Callable接口来创建线程
    @Test
    public void testCreateThreadByImplCallable() {

        //1.创建实现Callable接口的类
        class MyCallable<Integer> implements Callable {
            @Override
            public Object call() throws Exception {
                System.out.println("实现Callable接口的call方法启动一个线程");
                Thread currentThread = Thread.currentThread();
                //输出该线程信息
                System.out.println("callableThreadId:"
                        + currentThread.getId()
                        + ",threadName1:"
                        + currentThread.getName());
                return 1;
            }
        }

        //2.创建一个Callable实现类类对象
        MyCallable myCallable = new MyCallable<Integer>();

        //3.由Callable<Integer>创建一个FutureTask<Integer>对象
        FutureTask<Integer> futureTask = new FutureTask<Integer>(myCallable);

        //4.由FutureTask<Integer>创建一个Thread对象
        Thread futureThread = new Thread(futureTask);

        //5.启动线程
        futureThread.start();
    }
}
