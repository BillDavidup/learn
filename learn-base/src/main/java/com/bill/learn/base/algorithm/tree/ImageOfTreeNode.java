package com.bill.learn.base.algorithm.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * 二叉树的景象问题
 * Created by bill on 2018/11/22.
 */
public class ImageOfTreeNode {
    public static TreeNode getImage(TreeNode root) {
        if (root != null) {
            Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
            queue.offer(root);
            exchange(root);
            while (queue.size() > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return null;
    }

    public static void exchange(TreeNode nodeChange) {
        if (nodeChange == null) {
            return ;
        }
        TreeNode temp = null;
        if (nodeChange.left != null) {
            temp = nodeChange.left;
            nodeChange.left = nodeChange.right;
        }
        if (nodeChange.right != null) {
            nodeChange.right = temp;
        }
    }
}
