package com.bill.learn.base.algorithm;

/**
 * @author wudening
 * @description: 插入排序
 * @date 2019-05-12 12:31
 */
public class InsertSort {

    public static void main(String[] args) {

        int[] sortArr = getSortArr();
        printArr(sortArr);
        //directInsertSort(sortArr, sortArr.length);
        halfInsertSort(sortArr, sortArr.length);
        printArr(sortArr);

    }

    /**
     * 直接插入排序
     * @param sortArr
     * @param length
     */
    public static void directInsertSort(int[] sortArr, int length) {

        for (int i = 1; i < length; i++) {
            int curTemp = sortArr[i];
            int j = i - 1;
            //TODO 根据下标取值的场景，应该判断条件写在前面，否者容易数组下标越界
            while (j >= 0 && sortArr[j] > curTemp) {
                sortArr[j + 1] = sortArr[j];
                j--;
            }
            sortArr[j + 1] = curTemp;
        }
    }

    /**
     * 折半插入排序
     * @param sortArr
     * @param length
     */
    public static void halfInsertSort(int[] sortArr, int length) {
        for (int i = 1; i < length; i++) {
            int curTemp = sortArr[i];
            int low = 0;
            int high = i - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (sortArr[mid] < curTemp) {
                    low  = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            for (int j = i - 1; j >= low; --j) {
                sortArr[j + 1] = sortArr[j];
            }
            sortArr[low] = curTemp;
        }
    }

    public static void printArr(int[] arr) {
        System.out.println("");
        System.out.println("------------打印数组元素------------");
        for (int num : arr) {
            System.out.print(" " + num);
        }
    }

    public static int[] getSortArr() {
        int[] sortArr = new int[]{48, 62, 35, 77, 55, 14, 35, 98};
        return sortArr;
    }
}
