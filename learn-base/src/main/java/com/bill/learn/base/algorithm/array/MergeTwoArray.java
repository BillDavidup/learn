package com.bill.learn.base.algorithm.array;

/**
 * 合并两个有序数组
 */
public class MergeTwoArray {
    public static void main(String[] args) {
        int[] arrA = ArrayTools.initArrA();
        int[] arrB = ArrayTools.initArrB();
        System.out.println("数组");
        ArrayTools.printArr(arrA);
        ArrayTools.printArr(arrB);
        int[] result = mergeTwoArray(arrA, arrB);
        ArrayTools.printArr(result);

    }

    // 复制的过程，其实跟归并排序的合并部分很像，只不过归并是在一个数组里面完成的
    // 而这个是在两个数组中完成
    public static int[] mergeTwoArray(int[] arrA, int[] arrB) {
        // 校验
        if (arrA == null) {
            return arrB;
        }
        if (arrB == null) {
            return arrA;
        }
        int a = 0;  // arrA数组的下标索引
        int aLength = arrA.length - 1;
        int b = 0; // arrB数组的下标索引
        int bLength = arrB.length - 1;

        int[] temp = new int[arrA.length + arrB.length];
        int k = 0;

        while (a <= aLength && b <= bLength) {
            temp[k++] = arrA[a] < arrB[b] ? arrA[a++] : arrB[b++];
        }
        //将有数组中剩下的元素复制到目标数组中去，仅有一个可以执行；
        while (a <= aLength) {
            temp[k++] = arrA[a++];
        }

        while (b <= bLength) {
            temp[k++] = arrB[b++];
        }
        return temp;
    }
}
