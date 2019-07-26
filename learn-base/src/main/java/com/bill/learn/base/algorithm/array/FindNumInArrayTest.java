package com.bill.learn.base.algorithm.array;

/**
 * @author wudening
 * @description: 从二维数组中查找指定的num, 二维数组行递增 列递增
 * @date 2019-07-26 21:09
 */
public class FindNumInArrayTest {
    public static void main(String[] args) {
        int[][] arr = ArrayTools.initTwoDimensionArray();
        boolean hasFindNum = findNumInTwoDimensionArray(arr, 200);
        System.out.println("查找二维数组的结果：" + hasFindNum);
    }

    public static boolean findNumInTwoDimensionArray(int[][] arr, int num) {
        int left = 0;
        int right = arr[0].length - 1;
        boolean flag = true;
        while (flag && left >= 0 && left <= arr.length - 1 && right >= 0 && right <= arr[0].length - 1) {
            int temp = arr[left][right];
            if (num > temp) {
                left++;
            } else if (num < temp) {
                right--;
            } else {
                //找到了num == temp
                flag = false;
            }
        }
        return !flag;
    }

}
