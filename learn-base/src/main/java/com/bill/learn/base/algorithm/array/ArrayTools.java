package com.bill.learn.base.algorithm.array;

/**
 * @author wudening
 * @description: 数组工具类
 * @date 2019-07-26 21:20
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

    /**
     * 初始化二维数组
     * 特点：行递增 列递增 可重复
     * @return arr
     */
    public static int[][] initTwoDimensionArray() {
        int[][] arr = {
                {1,9,10,12},
                {2,11,14,15},
                {3,12,16,19},
                {4,13,17,20}};
        return arr;
    }
    public static int[] initArrA() {
        return new int[] {1, 3,5, 7, 9, 23};
    }
    public static int[] initArrB() {
        return new int[] {2, 4, 6, 8, 10, 22};
    }
}
