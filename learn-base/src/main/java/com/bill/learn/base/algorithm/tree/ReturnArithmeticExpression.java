package com.bill.learn.base.algorithm.tree;

/**
 * 将一个二叉树转换为表达式，优先级需要加括号
 * Created by bill on 2018/11/29.
 */
public class ReturnArithmeticExpression {

    public static void returnArithmeticExpression(TreeNode root) {
        if (root != null) {
            if (isOperator(root.value)) {
                System.out.print("(");
            }
            returnArithmeticExpression(root.left);
            System.out.print(root.value);
            returnArithmeticExpression(root.right);
            if (isOperator(root.value)) {
                System.out.print(")");
            }
        }
    }

    /**
     * 判断是否是运算符
     * @param s
     * @return
     */
    public static boolean isOperator(String s) {
        if ("+".equals(s) || "-".equals(s)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断是否是数字
     * @param s
     * @return
     */
    public static boolean isDigital(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断option1和option2运算符的优先级
     * @param option1
     * @param option2
     * @return true：op1优先于op2
     */
    public static boolean isPrior(String option1, String option2) {
        if (getPriorLevel(option1) > getPriorLevel(option2)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取运算符的优先级
     * @param s
     * @return
     */
    public static int getPriorLevel(String s) {
        if ("+".equals(s) || "-".equals(s)) {
            return 1;
        } else if ("*".equals(s) || "/".equals(s)) {
            return 2;
        } else {
            throw new IllegalArgumentException("不支持的操作符，仅限+-*/");
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode("+");
        TreeNode node2 = new TreeNode("-");
        TreeNode node3 = new TreeNode("*");
        TreeNode node4 = new TreeNode("/");
        TreeNode nodea = new TreeNode("a");
        TreeNode nodeb = new TreeNode("b");
        TreeNode nodec = new TreeNode("c");
        TreeNode noded = new TreeNode("d");
        TreeNode nodee = new TreeNode("e");
        TreeNode nodef = new TreeNode("f");
        TreeNode node5 = new TreeNode("-");
        node2.left = node1;
        node2.right = node4;
        node1.left = nodea;
        node1.right = node3;
        node3.left = nodeb;
        node3.right = node5;
        node5.left = nodec;
        node5.right = noded;
        node4.left = nodee;
        node4.right = nodef;
        returnArithmeticExpression(node2);
    }
}
