package com.ds.algo.one;

public class SolutionService6 {

    public static void main(String[] args) {
        BinaryTree node1 = new BinaryTree(1);
        BinaryTree node2 = new BinaryTree(2);
        BinaryTree node3 = new BinaryTree(3);
        BinaryTree node4 = new BinaryTree(4);
        BinaryTree node5 = new BinaryTree(5);
        BinaryTree node6 = new BinaryTree(6);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        boolean flag = checkSymmetric(node1);
        System.out.println("Symmetric: " + flag);

        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.right = new BinaryTree(4);
        root.right.left = new BinaryTree(5);
        flag = checkSymmetric(root);
        System.out.println("Symmetric: " + flag);
    }

    private static boolean checkSymmetric(BinaryTree root) {
        if (root == null) {
            return true;
        }
        return checkSymmetric(root.left, root.right);
    }

    private static boolean checkSymmetric(BinaryTree left, BinaryTree right) {
        if (left == null && right == null) {
            return true;
        }
        return (left != null && right != null && checkSymmetric(left.left, right.right) && checkSymmetric(left.right, right.left));
    }

}
