package com.bill.learn.base.algorithm;

/**
 * @author wudening
 * @description: 数组工具类
 * @date 2019-08-10 11:10
 */
public class ArrayTools {
    public static void printArr(int[] arr) {
        System.out.println("--------------------------");
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - 1) {
                System.out.print(arr[i] + ",");
            } else {
                System.out.println(arr[i]);
            }
        }
    }
}
