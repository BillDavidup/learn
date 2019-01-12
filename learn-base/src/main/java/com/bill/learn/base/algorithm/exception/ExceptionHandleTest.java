package com.bill.learn.base.algorithm.exception;

public class ExceptionHandleTest {
    public static void main(String[] args) {
        invoke();
    }

    public static void insertException(int step) {
        int num = 5;
        if (step == 3) {
            num = 0;
        }
        try {
            int i = 4 / num;
        } catch (Exception e) {
            System.out.println("模拟日志上报insertException");
            System.out.println(e.getClass().getName());
            throw e;
        }
    }

    public static void invoke() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("传入的参数i=" + i);
                insertException(i);
            }
        } catch (Exception e) {
            System.out.println("模拟日志上报，invoke");
        }
    }
}
