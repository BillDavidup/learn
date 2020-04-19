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

    /**
     * 初始化一个int数组
     * @return 数组
     */
    public static int[] initArr() {
        //return new int[] {48,62,35,77,55,14,35,98};
        return new int[] {6,1,2,7,9,3,4,5,10,8};
    }

    /**
     * 初始化一个升序int数组
     * @return 数组
     */
    public static int[] initSortArr() {
        //return new int[] {48,62,35,77,55,14,35,98};
        return new int[] {1,2,2,7,9,10,11,14,15,30,58};
    }
}
