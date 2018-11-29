package com.bill.learn.base.algorithm.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * 题目：给你一个N个元素数组（元素不重复），输出一个M元素的数组（0<M<=N）,保证等概率
 * 出处：猿辅导
 * 题目背景：M道题目，选出N道不重复，给猿搜题用户推荐。
 * Created by bill on 2018/11/29.
 */
public class RandomArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("数组等概率重排前");
        printArray(arr);
        randomArray(arr);
        System.out.println();
        System.out.println("数组等概率重排后");
        printArray(arr);
        System.out.println("等概率取出n个元素为：");
        ArrayList arrayList = randomArray2(arr, 5);
        arrayList.forEach(v -> System.out.print(v + " "));
    }

    /**
     * 等概率打乱一个包含N个元素数组
     *
     * @param arr
     */
    public static void randomArray(int[] arr) {
        int size = arr.length;
        Random random = new Random();
        for (int i = size; i > 1; i--) {
            swap(arr, i - 1, random.nextInt(i));
        }
    }

    /**
     * @param arr
     * @param m
     * @return 返回包含N个元素的数组，且每个元素等概率
     */
    public static ArrayList randomArray2(int[] arr, int m) {
        if (arr == null || arr.length == 0 || m < 0 || m > arr.length) {
            new ArithmeticException("输入参数错误");
        }
        int count = 0;
        int randomIndex = 0;
        ArrayList arrList = new ArrayList<Integer>(); //保存返回的有序数组
        while (count < m) {
            randomIndex = (int) Math.random() * (arr.length - count);//缩小每次随机数产生的范围
            //取出randomIndex的值保存下来
            arrList.add(arr[randomIndex]);
            //原数组的值等概率交换
            swap(arr, arr.length - count - 1, randomIndex);
            count++;
        }
        return arrList;
    }

    /**
     * 两个值交换
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 数组输出格式化
     * @param arr
     */
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
