package com.ds.algo.one;

public class SolutionService5 {

    public static int diameter = 0;

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
        diameterOfTree(node1);
        System.out.println("Diameter: "+diameter);

        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.right = new BinaryTree(4);
        root.right.left = new BinaryTree(5);
        root.right.right = new BinaryTree(6);
        root.right.left.left = new BinaryTree(7);
        root.right.left.right = new BinaryTree(8);
        diameterOfTree(root);
        System.out.println("Diameter: "+diameter);
    }

    public static void diameterOfTree(BinaryTree root) {
        if (root == null) {
            return;
        }
         diameter(root);
    }

    private static int diameter(BinaryTree root) {
        if (root == null) {
            return 0;
        }

        int left = diameter(root.left);
        int right = diameter(root.right);

        int sum = left + right + 1;

        if(sum >= diameter) {
            diameter = sum;
        }

        return Math.max(left, right) + 1;
    }


}
