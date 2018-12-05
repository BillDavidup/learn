package com.bill.learn.base.algorithm.tree;

/**
 * 从根节点开始，求二叉树的所有链路中和的最大值
 * Created by bill on 2018/12/5.
 */
public class RoadMaxSum {
    /**
     * 递归
     * @param root
     * @return
     */
    public static int getRoadMaxSum(BinaryTreeNode root) {
       int sumLeft = 0;
       int sumRight = 0;
       if (root.leftChild != null) {
           sumLeft = getRoadMaxSum(root.leftChild);
       }
       if (root.rightChild != null) {
           sumRight = getRoadMaxSum(root.rightChild);
       }

       int maxSum = 0;
       if (sumLeft < sumRight) {
           maxSum = sumRight + root.key;
       } else {
           maxSum = sumLeft + root.key;
       }
       return maxSum;
    }

    public static void main(String[] args) {
        BinaryTreeNode node3 = new BinaryTreeNode(3, "three");
        BinaryTreeNode node2 = new BinaryTreeNode(2, "second");
        BinaryTreeNode node1 = new BinaryTreeNode(1, "first");
        BinaryTreeNode node5 = new BinaryTreeNode(5, "five");
        BinaryTreeNode node4 = new BinaryTreeNode(4, "four");
        BinaryTreeNode node9 = new BinaryTreeNode(9, "nine");
        BinaryTreeNode node8 = new BinaryTreeNode(8, "eight");
        node3.leftChild = node2;
        node3.rightChild = node1;
        node2.leftChild = node5;
        node2.rightChild = node4;
        node1.leftChild = node9;
        node1.rightChild = node8;
        System.out.println("二叉树的最大链路和为：" + getRoadMaxSum(node3));
    }
}
