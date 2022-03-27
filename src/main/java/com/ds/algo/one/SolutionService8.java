package com.ds.algo.one;

public class SolutionService8 {

    public static void main(String[] args) {
        BinaryTree node1 = new BinaryTree(1);
        BinaryTree node2 = new BinaryTree(2);
        BinaryTree node3 = new BinaryTree(3);
        BinaryTree node4 = new BinaryTree(4);
        BinaryTree node5 = new BinaryTree(5);
        BinaryTree node6 = new BinaryTree(6);
        BinaryTree root1 = node1;

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;

        BinaryTree nod1 = new BinaryTree(1);
        BinaryTree nod2 = new BinaryTree(2);
        BinaryTree nod3 = new BinaryTree(3);
        BinaryTree nod4 = new BinaryTree(4);
        BinaryTree nod5 = new BinaryTree(5);
        BinaryTree nod6 = new BinaryTree(6);
        BinaryTree root2 = nod1;

        nod1.left = nod2;
        nod1.right = nod3;
        nod2.left = nod4;
        nod2.right = nod5;
        nod3.left = nod6;

        Boolean flag = checkSymmetric(root1, root2);
        System.out.println("Symmetric: " + flag);

        BinaryTree no1 = new BinaryTree(1);
        BinaryTree no2 = new BinaryTree(2);
        BinaryTree no3 = new BinaryTree(3);
        BinaryTree no4 = new BinaryTree(4);
        BinaryTree no5 = new BinaryTree(5);
        BinaryTree no6 = new BinaryTree(6);
        BinaryTree root3 = no1;

        no1.left = no3;
        no1.right = no2;
        no3.right = no6;
        no2.left = no5;
        no2.right = no4;

        flag = checkSymmetric(root1, root3);
        System.out.println("Symmetric: " + flag);
    }

    private static Boolean checkSymmetric(BinaryTree root1, BinaryTree root2) {

        if(root1 == null && root2 == null) {
            return true;
        }

        return (root1 != null && root2 != null && checkSymmetric(root1.right, root2.right)
                && checkSymmetric(root1.left, root2.left) && root1.val == root2.val);
    }


}
