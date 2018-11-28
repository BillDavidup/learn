package com.bill.learn.base.algorithm.tree;

/**
 * Created by bill on 2018/11/28.
 */
public class BinaryTreeNode {
    public int key;
    public String name;
    public BinaryTreeNode leftChild;
    public BinaryTreeNode rightChild;

    public BinaryTreeNode(int key, String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + "has a key:" + key;
    }
}
