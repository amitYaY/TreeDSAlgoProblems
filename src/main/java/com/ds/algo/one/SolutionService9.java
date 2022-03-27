package com.ds.algo.one;

public class SolutionService9 {

    public static void main(String[] args) {
        BinaryTree node1 = new BinaryTree(1);
        BinaryTree node2 = new BinaryTree(2);
        BinaryTree node3 = new BinaryTree(3);
        BinaryTree node4 = new BinaryTree(4);
        BinaryTree node5 = new BinaryTree(5);
        BinaryTree node6 = new BinaryTree(6);
        BinaryTree node7 = new BinaryTree(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        BinaryTree root = node1;
        printTree(root);
        convertToMirror(root);
        System.out.println();
        printTree(root);
    }

    private static void swap(BinaryTree root) {
        if(root == null) {
            return;
        }
        BinaryTree temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    private static void convertToMirror(BinaryTree root) {
        if(root == null) {
            return;
        }
        convertToMirror(root.left);
        convertToMirror(root.right);
        swap(root);
    }

    private static void printTree(BinaryTree root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val+" ");
        printTree(root.left);
        printTree(root.right);
    }
}
