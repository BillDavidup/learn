package com.bill.learn.base.algorithm.array;

/**
 * 数组反转
 * Created by bill on 2018/11/23.
 */
public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6};
        int[] arr2 = new int[] {1, 2, 3, 4, 5, 6, 7};
        printArr(arr2);
        reverseArr(arr2);
        printArr(arr2);
    }

    /**
     * 最优解，修改原数组
     * @param arr 待逆置的数组
     */
    public static void reverseArr(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
