package com.ds.algo.one;

public class SolutionService3 {

    public static BinaryTree lca = null;

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
        BinaryTree root = node1;
        BinaryTree x = node4;
        BinaryTree y = node6;

        if(isNodeExists(root, x) && isNodeExists(root, y)) {
            findLCA(root, x, y);
        }

        System.out.println("LCA:" + lca.val);
    }

    public static Boolean isNodeExists(BinaryTree root, BinaryTree node) {
        if(root == null) {
            return false;
        }
        if(root == node) {
            return true;
        }
        return isNodeExists(root.left, node) || isNodeExists(root.right, node);
    }

    public static Boolean findLCA(BinaryTree root, BinaryTree node1, BinaryTree node2) {

        if(root == null) {
            return false;
        }

        if(root == node1 || root == node2) {
            lca = root;
            return true;
        }

        Boolean left = findLCA(root.left, node1, node2);
        Boolean right = findLCA(root.right, node1, node2);

        if(left && right) {
            lca = root;
        }

        return left || right;
    }

}
