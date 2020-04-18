package com.bill.learn.base.algorithm;

/**
 * 冒泡排序
 * https://www.meiwen.com.cn/subject/xrfqhqtx.html
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = ArrayTools.initArr();
        System.out.println("排序前");
        ArrayTools.printArr(arr);
        System.out.println("排序后");
        //bubbleSortP(arr);
        cocktailSort(arr);
        ArrayTools.printArr(arr);
    }

    // 冒泡排序：原始
    public static void bubbleSortP(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // 冒泡排序：鸡尾酒排序
    // 思想：先从左边到右遍历，最大数沉底，最大索引-1；然后从右到左遍历，最小数上浮，最小索引+1
    public static void cocktailSort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
            right--;
            for (int j = right; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
            left++;
        }

    }

    /**
     * 数组两个下标值交换
     * @param arr arr
     * @param pre p
     * @param next n
     */
    private static void swap(int[] arr, int pre, int next) {
        int temp = arr[pre];
        arr[pre] = arr[next];
        arr[next] = temp;
    }
}
