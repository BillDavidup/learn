package com.bill.learn.base.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 利用线程池执行FutureTask任务，获取任务执行结果
 * Created by bill on 2018/11/2.
 */
public class FutureTaskTest {

    //2.任务类
    private static class ComputeTask implements Callable<Integer> {
        private Integer result = 0;
        private String computerTaskName = "";

        //构造方法
        public ComputeTask(Integer iniResult, String computerTaskName) {
            result = iniResult;
            this.computerTaskName = computerTaskName;
            System.out.println("生成的子线程计算任务：" + computerTaskName);
        }

        //获取子线程名称
        public String getComputerTaskName() {
            return computerTaskName;
        }

        @Override
        public Integer call() throws Exception {

            for (int i = 1; i <= 10; i++) {
                result = result + i;
            }

            Thread.sleep(5000);

            System.out.println("子线程计算任务: " + computerTaskName + " 执行完成!");

            return result;
        }
    }

    /**
     * 多任务计算
     * @param args
     */
    public static void main(String[] args) {
        //1.任务列表
        List<FutureTask<Integer>> futureTaskList = new ArrayList<FutureTask<Integer>>();
        //2.线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //3.创建任务并提交给线程池处理
        for (int i = 1; i <= 10; i++) {
            FutureTask<Integer> futureTask = new  FutureTask<Integer>(new ComputeTask(0, "第" + i + "线程"));
            futureTaskList.add(futureTask);
            executorService.submit(futureTask);
        }
        //4.统计各子线程异步计算结果
        Integer finalResult = 0;
        for (FutureTask<Integer> task : futureTaskList) {
            try {
                finalResult += task.get(5, TimeUnit.SECONDS);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                System.out.println(e.toString());
            }
        }
        //5.关闭线程池
        executorService.shutdown();
        System.out.println("多任务计算后的结果是：" + finalResult);
    }
}
