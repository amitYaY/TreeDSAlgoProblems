package com.ds.algo.one;

public class SolutionService10 {

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
        BinaryTree newRoot = createMirror(root);
        System.out.println();
        printTree(newRoot);
    }

    private static BinaryTree createMirror(BinaryTree root) {
        if(root == null) {
            return null;
        }
        BinaryTree left = createMirror(root.left);
        BinaryTree right = createMirror(root.right);

        BinaryTree temp = new BinaryTree();
        temp.right = left;
        temp.left = right;
        temp.val = root.val;
        return temp;
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
