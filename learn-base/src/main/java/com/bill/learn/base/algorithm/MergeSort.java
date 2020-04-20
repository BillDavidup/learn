package com.bill.learn.base.algorithm;

/**
 * @author wudening
 * @description: 两路归并排序 https://www.jianshu.com/p/33cffa1ce613
 * @date 2019-08-10 10:15
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = init();
        ArrayTools.printArr(arr);
        mergeSort(arr);
        ArrayTools.printArr(arr);
    }

    public static int[] init() {
        int[] arr = {4, 66, 34, 2, 99, 7, 80, 1};
        return arr;
    }

    public static void mergeSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    /**
     * （归的过程）
     *
     * @param arr  待排序的数组
     * @param low  数组最低位坐标
     * @param high 数组最高位坐标
     */
    public static void sort(int[] arr, int low, int high) {
        //递归结束条件
        if (low == high) {
            return;
        }
        int mid = low + ((high - low) >> 1);
        //左子数组排好序
        sort(arr, low, mid);
        //右边子数组排好序
        sort(arr, mid + 1, high);
        //进行一次归并操作
        merge(arr, low, mid, high);
    }

    /**
     * 并的过程
     * 两个递增子序列的合成(合的过程)，将一个数组的分为2部分，
     * 用临时数组暂存排序结果
     * @param arr  待排序的数组
     * @param low  左子区间数组最低位索引
     * @param mid  左子区间数组最高位索引
     * @param high 右子区间数组最低位索引
     */
    public static void merge(int[] arr, int low, int mid, int high) {
        int k = 0;
        int[] temp = new int[high - low + 1];
        int i = low;     //左子数组第一个下标
        int j = mid + 1; //右子数组第一个下标
        //比较左右两个子数组的元素，将小的元素填入temp中
        while (i <= mid && j <= high) {
            temp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }
        //以下两while仅有一个会执行，将剩余元素复制到临时数组
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= high) {
            temp[k++] = arr[j++];
        }
        //把最终的排序结果复制到原数组
        for (i = 0; i < temp.length; i++) {
            arr[low + i] = temp[i];
        }
    }

}
