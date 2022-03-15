package com.ds.algo.one;

public class BinaryTree {

    public int val;
    public BinaryTree left;
    public BinaryTree right;

    BinaryTree() {
    }

    BinaryTree(int val) {
        this.val = val;
    }

    BinaryTree(int val, BinaryTree left, BinaryTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "val=" + val +
                '}';
    }

    public static BinaryTree getInput() {
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
        return node1;
    }
}
