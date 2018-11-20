package com.bill.learn.base.algorithm.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by bill on 2018/11/20.
 */
public class Traverse {
    /**
     * 非递归实现:前序遍历
     * @param root 树根节点
     */
    public static void preOrder(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                System.out.print(pop.value + " ");
                if (pop.right != null) {
                    stack.push(pop.right);
                }
                if (pop.left != null) {
                    stack.push(pop.left);
                }
            }
            System.out.println();
        }
    }

    /**
     * 非递归实现：中序遍历
     * @param root 树根结点
     */
    public static void inOrder(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack  = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    System.out.print(root.value + " ");
                    root = root.right;
                }
            }
            System.out.println();
        }
    }

    /**
     * 非递归实现：后序遍历
     * @param root 树根节点
     */
    public static void posOrder(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack1 = new Stack<TreeNode>();
            Stack<TreeNode> stack2 = new Stack<TreeNode>();
            stack1.push(root);
            while (!stack1.isEmpty()) {
                TreeNode pop = stack1.pop();
                stack2.push(pop);
                if (pop.left != null) {
                    stack1.push(pop.left);
                }
                if (pop.right != null) {
                    stack1.push(pop.right);
                }
            }
            while (!stack2.isEmpty()) {
                System.out.print(stack2.pop().value + " ");
            }
            System.out.println();
        }
    }


    /**
     * 非递归实现：层次遍历
     * @param root 树根节点
     */
    public static void levelOrder(TreeNode root) {
        if (root != null) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                //获取当前层的节点数
                int levleNum = queue.size();
                for (int i = 0; i < levleNum; i++) {
                    TreeNode poll = queue.poll();
                    System.out.print(poll.value + " ");

                    if (poll.left != null) {
                        queue.offer(poll.left);
                    }
                    if (poll.right != null) {
                        queue.offer(poll.right);
                    }
                }
            }
        }
    }

    /**
     * 测试
     * @param args a
     */
    public static void main(String[] args) {
        TreeNode A = new TreeNode("A");
        TreeNode B = new TreeNode("B");
        TreeNode C = new TreeNode("C");
        TreeNode D = new TreeNode("D");
        TreeNode E = new TreeNode("E");
        TreeNode F = new TreeNode("F");
        TreeNode G = new TreeNode("G");
        TreeNode H = new TreeNode("H");
        TreeNode I = new TreeNode("I");
        TreeNode J = new TreeNode("J");
        TreeNode K = new TreeNode("K");

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        D.left = H;
        D.right = I;
        E.right = J;
        C.left = F;
        C.right = G;
        F.right = K;

        preOrder(A);
        inOrder(A);
        posOrder(A);
        levelOrder(A);

    }

}
