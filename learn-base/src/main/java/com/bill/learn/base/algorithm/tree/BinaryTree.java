package com.bill.learn.base.algorithm.tree;

/**
 * Created by bill on 2018/11/28.
 */
public class BinaryTree {
    BinaryTreeNode root;

    /**
     * 插入结点
     * @param value   二叉排序树结点的值
     * @param name  二叉排序树结点的
     */
    public  void addNode(int value, String name) {
        BinaryTreeNode newNode = new BinaryTreeNode(value, name);
        if (root == null) {
            root = newNode;
        } else {
            BinaryTreeNode focusNode = root;

            BinaryTreeNode parent;

            while (true) {
                parent = focusNode;
                if (value < focusNode.key) {
                    focusNode = focusNode.leftChild;
                    if (focusNode == null) {
                        parent.leftChild = newNode;
                        return ;
                    }
                } else {
                    focusNode = focusNode.rightChild;
                    if (focusNode == null) {
                        parent.rightChild = newNode;
                        return ;
                    }
                }
            }
        }
    }

    /**
     * 查找
     * @param key
     * @return
     */
    public BinaryTreeNode findNode(int key) {

        BinaryTreeNode focusNode = root;
        while (focusNode.key != key) {
            if (key < focusNode.key) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }
            if (focusNode == null) {
                return null;
            }
        }
        return focusNode;
    }

    /**
     * 获取二叉排序树中最小值的节点
     * @param focusNode
     * @return
     */
    public BinaryTreeNode getMinTreeNode(BinaryTreeNode focusNode) {
        if (focusNode.leftChild == null) {
            return focusNode;
        }
        return getMinTreeNode(focusNode.leftChild);
    }

    /**
     * 获取二叉排序树中最大值的节点
     * @param focusNode
     * @return
     */
    public BinaryTreeNode getMaxTreeNode(BinaryTreeNode focusNode) {
        if (focusNode.rightChild == null) {
            return focusNode;
        }
        return getMaxTreeNode(focusNode.rightChild);
    }

    /**
     *  先序遍历
     * @param focusNode
     */
    public static void preOrderTraverse(BinaryTreeNode focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode);
            preOrderTraverse(focusNode.leftChild);
            preOrderTraverse(focusNode.rightChild);
        } else {
            return ;
        }
    }

    /**
     * 中序遍历
     * @param focusNode
     */
    public static void inOrderTraverse(BinaryTreeNode focusNode) {
        if (focusNode != null) {
            inOrderTraverse(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTraverse(focusNode.rightChild);
        } else {
            return ;
        }
    }

    /**
     * 后序遍历
     * @param focusNode
     */
    public static void postOrderTraverse(BinaryTreeNode focusNode) {
        if (focusNode != null) {
            postOrderTraverse(focusNode.leftChild);
            postOrderTraverse(focusNode.rightChild);
            System.out.println(focusNode);
        } else {
            return ;
        }
    }

    public static void main(String[] args) {
        BinaryTree theTree = new BinaryTree();
        theTree.addNode(50,"Vice Pres");
        theTree.addNode(25,"Vice Pres");
        theTree.addNode(15,"Office Manager");
        theTree.addNode(30,"Secretary");
        theTree.addNode(75,"Sales Manager");
        theTree.addNode(85,"Salesman 1");

        System.out.println("--------先序遍历--------");
        preOrderTraverse(theTree.root);
        System.out.println("--------中序遍历--------");
        inOrderTraverse(theTree.root);
        System.out.println("--------后序遍历--------");
        postOrderTraverse(theTree.root);
        System.out.println("--------查找结点--------");
        System.out.println(theTree.findNode(35));
        System.out.println("--------查最小值结点--------");
        System.out.println(theTree.getMinTreeNode(theTree.root));
        System.out.println("--------查找最大值结点--------");
        System.out.println(theTree.getMaxTreeNode(theTree.root));

    }
}
