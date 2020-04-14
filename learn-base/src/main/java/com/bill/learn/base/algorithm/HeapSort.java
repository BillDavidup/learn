package com.bill.learn.base.algorithm;

/**
 * 堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = ArrayTools.initArr();
        ArrayTools.printArr(arr);
        heapSort(arr, arr.length);
        ArrayTools.printArr(arr);
    }

    // 堆排序，升序用最大堆，降序用最小堆，这里是升序
    // 数组下标从0开始
    public static void heapSort(int[] arr, int length) {
        int i;
        int temp;
        // 1建初堆：将不符合最大堆的原数组初始化为最大堆
        // 从最后一个非叶子节点开始向上调整到堆顶
        for (i = length / 2 - 1; i >= 0; --i) {
            shift(arr, i, length - 1);
        }
        // 2 堆排序过程：经过第一步建初堆，堆顶是最大的数，将最大数移到数组最后，将length - 1元素进行调整，得到次大数，依次重复
        // 最后得到升序数组，完成排序过程
        for (i = length - 1; i > 0; --i) {
            // 最大元素入数组末尾，剩下的元素进行最大堆调整
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            shift(arr, 0, i - 1);
        }
    }

    /**
     * 调整堆方法
     * i: 父节点 j:子节点（最左节点）
     *
     * @param arr 数组引用
     * @param low  调整的节点开始范围
     * @param high 调整的节点结束范围
     */
    public static void shift(int[] arr, int low, int high) {
        // 为根节点，跟根节点的左孩子进行调
        int i = low;
        int j = 2 * i + 1;
        int temp = arr[i];
        while (j <= high) {
            // 将j指向i节点的孩子节点中值最大的那个
            if (j < high && arr[j] < arr[j + 1]) {
                ++j;
            }
            // 如果孩子节点比父节点大，将父节点值替换为最大的，同时i指向下一个节点，j指向下一个节点的左孩子节点
            // 如果孩子节点比父节点小或相等，停止这次循环
            if (temp < arr[j]) {
                arr[i] = arr[j];
                i = j;
                j = 2 * i + 1;
            } else {
                break;
            }
        }
        // 对于最大堆就是最小值填入恰当的位置
        arr[i] = temp;
    }
}
