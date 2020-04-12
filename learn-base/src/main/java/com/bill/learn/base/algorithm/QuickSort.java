package com.bill.learn.base.algorithm;

import java.util.Stack;

/**
 * 快速排序
 * https://zhuanlan.zhihu.com/p/64248126
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = ArrayTools.initArr();
        System.out.println("排序前");
        ArrayTools.printArr(arr);
        System.out.println("排序后");
        // 递归实现
        // quickSort(arr,0, arr.length - 1);
        quickSort2(arr);
        // 非递归实现
        ArrayTools.printArr(arr);

    }

    // 1递归实现：快速排序
    private static void quickSort(int[] arr, int low, int high) {
        /*// 校验
        if (arr == null || low >= high) {
            return ;
        }*/
        if (low < high) {
            // 将数组分为两部分
            int pivot = quickPass(arr, low, high);
            // 递归排序左子数组
            quickSort(arr, low, pivot - 1);
            // 递归排序右子数组
            quickSort(arr, pivot + 1, high);

        }
    }

    // 1递归实现：一趟快速排序
    private static int quickPass(int[] arr, int low, int high) {
        // 基准枢纽记录
        int pivotVal = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivotVal) {
                high--;
            }
            // 交换比基准值小的记录到左端
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivotVal) {
                low++;
            }
            // 交换比基准值大的记录到右端
            arr[high] = arr[low];
        }
        // 扫描完成，枢纽到位
        arr[low] = pivotVal;
        //返回的是枢纽的位置，该枢纽位置左边的子数组都比该值小，右边的子数组都比该值大
        return low;
    }

    // 2非递归实现：
    public static void quickSort2(int[] arr) {
        // 校验
        if (arr == null || arr.length <= 1) {
            return;
        }
        // 用栈存放开始与结束索引
        Stack<Integer> s = new Stack<Integer>();
        s.push(0);
        s.push(arr.length - 1);
        // 利用循环实现
        while (!s.isEmpty()) {
            int high = s.pop();
            int low = s.pop();
            //如果最大索引小于等于左边索引，说明结束了
            if (high <= low) {
                continue;
            }
            int pivot = quickPass(arr, low, high);
            if (low < pivot - 1) {
                s.push(low);
                s.push(pivot - 1);
            }
            if (high > pivot + 1) {
                s.push(pivot + 1);
                s.push(high);
            }
        }
    }

}
