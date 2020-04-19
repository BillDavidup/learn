package com.bill.learn.base.algorithm.search;

import com.bill.learn.base.algorithm.ArrayTools;

/**
 * 二分查找法
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = ArrayTools.initSortArr();
        System.out.println("原数组：");
        ArrayTools.printArr(arr);
        // 二分查找
        int key = 11;
        int index = binarySearch(arr, key);
        System.out.println("key:" + key + ",index=" + index);
    }

    // 数组必须是有序的
    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > key) {
                high = mid - 1;
            }
            if (arr[mid] < key) {
                low = mid + 1;
            }
            if (arr[mid] == key) {
                return mid;
            }
        }
        // 查找不到返回
        return -1;
    }
}
