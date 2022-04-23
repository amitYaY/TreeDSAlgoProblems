package com.ds.algo.one;

public class SolutionService15 {

    private static BinaryTree insertNode(BinaryTree tree, int val) {
        if(tree == null) {
            BinaryTree root = new BinaryTree();
            root.val = val;
            return root;
        }

        if(tree.val == val) {
            return tree;
        }

        if(tree.val > val) {
            tree.left = insertNode(tree.left, val);
        } else {
            tree.right = insertNode(tree.right, val);
        }
        return tree;
    }

    private static BinaryTree deleteNode(BinaryTree tree, int val) {

        if(tree == null) {
            return null;
        }

        if(tree.val == val) {
            if(isLeaf(tree)) {
                return null;
            }
            if(tree.left == null) {
                BinaryTree temp = tree.right;
                tree.right = null;
                return temp;
            }
            if(tree.right == null) {
                BinaryTree temp = tree.left;
                tree.left = null;
                return temp;
            }

            BinaryTree node = findRightMostChild(tree.left);
            int temp = node.val;
            deleteNode(tree, temp);
            tree.val = node.val;
            return tree;

        }
        if(tree.val > val) {
            tree.left = deleteNode(tree.left, val);
        } else {
            tree.right = deleteNode(tree.right, val);
        }
        return tree;
    }

    public static BinaryTree findRightMostChild(BinaryTree root) {
        if(root == null) {
            return null;
        }
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public static BinaryTree parentNode(BinaryTree root, BinaryTree childNode) {
        if(root == null || childNode == null || (root == childNode)) {
            return null;
        }
        if(root.right == childNode || root.left == childNode) {
            return root;
        }
        BinaryTree leftTree = parentNode(root.left, childNode);
        BinaryTree rightTree = parentNode(root.right, childNode);

        if(leftTree == null) {
            return rightTree;
        } else {
            return leftTree;
        }
    }
    
    private static Boolean isLeaf(BinaryTree root) {
        if(root == null) {
            return false;
        }
        return root.left == null && root.right == null;
    }

    private static void inorderTraversal(BinaryTree root) {

        if(root == null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.println(root.val+", ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        int val = 3;
        BinaryTree tree = insertNode(null, 5);
        insertNode(tree, 3);
        insertNode(tree, 6);
        insertNode(tree, 2);
        insertNode(tree, 4);
        insertNode(tree, 7);
        inorderTraversal(tree);
        tree = deleteNode(tree, val);
        inorderTraversal(tree);

        /* int val = 4;
        BinaryTree tree = insertNode(null, 1);
        insertNode(tree, 2);
        insertNode(tree, 3);
        insertNode(tree, 4);
        insertNode(tree, 5);
        insertNode(tree, 6);
        insertNode(tree, 7);
        insertNode(tree, 8);
        inorderTraversal(tree);
        tree = deleteNode(tree, val);
        inorderTraversal(tree);*/
    }
    
}
