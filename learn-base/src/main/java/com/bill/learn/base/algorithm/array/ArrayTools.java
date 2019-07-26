package com.bill.learn.base.algorithm.array;

/**
 * @author wudening
 * @description: 数组工具类
 * @date 2019-07-26 21:20
 */
public class ArrayTools {

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
}
