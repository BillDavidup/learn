package com.bill.learn.base.algorithm;

/**
 * @author wudening
 * @description: 斐波那契数列
 * @date 2019-06-18 00:33
 */
public class FibonacciSequence {
    /**
     * 测试
     * @param args args
     */
    public static void main(String[] args) {
        int n = 10;
        int result = getFibonacciSequence(n);
        System.out.println("N:" + n + ",result:" + result);
    }

    /**
     * 循环来做
     * 求斐波那契数列的第n列数是多少
     * @param n 要求的斐波那契数列的第n列
     * @return 返回第n列的值
     */
    public static int getFibonacciSequence(int n) {
        //极端值的处理
        int[] result = {-1,1};
        if (n < 2) {
            return result[n];
        }
        int firstNum = 0;
        int secondNum = 1;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = firstNum + secondNum;
            firstNum = secondNum;
            secondNum = sum;
        }
        return sum;
    }
}
