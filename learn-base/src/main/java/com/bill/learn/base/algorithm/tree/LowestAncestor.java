package com.bill.learn.base.algorithm.tree;

/**
 * 结点的最近祖先
 * Created by bill on 2018/11/22.
 */
public class LowestAncestor {
    /**
     *
     * @param root 树根结点
     * @param p p
     * @param q q
     * @return 祖先结点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
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

        LowestAncestor lowestAncestor = new LowestAncestor();
        TreeNode treeNode = lowestAncestor.lowestCommonAncestor(A, B, F);
        System.out.println(treeNode.value);


    }
}
