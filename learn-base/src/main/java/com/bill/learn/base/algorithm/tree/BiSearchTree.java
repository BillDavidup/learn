package com.bill.learn.base.algorithm.tree;

/**
 * 二叉排序树数据结构
 * 定义：二叉排序树或者是一棵空树，或者是具有下列性质的二叉树：
 *（1）若左子树不空，则左子树上所有结点的键值均小于或等于它的根结点的键值；
 *（2）若右子树不空，则右子树上所有结点的键值均大于或等于它的根结点的键值；
 *（3）左、右子树也分别为二叉排序树；
 * Created by bill on 2018/11/27.
 */
public class BiSearchTree {
    public int value;
    public BiSearchTree left;
    public BiSearchTree right;

    public BiSearchTree(int value) {
        this.value = value;
    }
}
