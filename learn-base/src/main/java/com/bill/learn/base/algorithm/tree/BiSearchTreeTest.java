package com.bill.learn.base.algorithm.tree;

/**
 * 二叉排序树的搜索、插入、删除，时间复杂度
 * Created by bill on 2018/11/27.
 */
public class BiSearchTreeTest {

    /**
     * 非递归
     * 二叉排序树的查找
     * @param root
     * @param num
     * @return
     */
    public static BiSearchTree search(BiSearchTree root, int num) {
        if (root == null) {
            return null;
        }
        while (root != null) {
            if (root.value == num) {
                return root;
            }
            if (num < root.value) {
                root = root.left;
            }
            if (num > root.value) {
                root = root.right;
            }
        }
        return null;
    }

    /**
     * 递归
     * 二叉排序树的查找
     * @param root
     * @param num
     * @return
     */
    public static BiSearchTree search2(BiSearchTree root, int num) {
        if (root == null) {
            return null;
        } else if (root.value == num) {
            return root;
        } else if (num < root.value) {
            return search2(root.left, num);
        } else {
            return search2(root.right, num);
        }
    }

    public static void main(String[] args) {
        BiSearchTree root = new BiSearchTree(20);
        BiSearchTree node5 = new BiSearchTree(5);
        BiSearchTree node10 = new BiSearchTree(10);
        BiSearchTree node13 = new BiSearchTree(13);
        BiSearchTree node15 = new BiSearchTree(15);
        BiSearchTree node17 = new BiSearchTree(17);
        BiSearchTree node18 = new BiSearchTree(18);
        BiSearchTree node19 = new BiSearchTree(19);
        BiSearchTree node22 = new BiSearchTree(22);
        BiSearchTree node25 = new BiSearchTree(25);
        BiSearchTree node28 = new BiSearchTree(28);
        BiSearchTree node29 = new BiSearchTree(29);
        BiSearchTree node30 = new BiSearchTree(30);
        BiSearchTree node35 = new BiSearchTree(35);
        BiSearchTree node100 = new BiSearchTree(100);

        root.left = node15;
        root.right = node29;
        node15.left = node10;
        node15.right = node18;
        node10.left = node5;
        node10.right = node13;
        node18.left = node17;
        node18.right = node19;
        node29.left = node25;
        node29.right = node35;
        node25.left = node22;
        node25.right = node28;
        node35.left = node30;
        node35.right = node100;

        BiSearchTree resultNode = search2(root, 99);

        if (resultNode != null) {
            System.out.println(resultNode.value);
        } else {
            System.out.println("没找到该结点");
        }
    }

}
