package com.ds.algo.one;

import java.util.ArrayList;
import java.util.List;

public class SolutionService17 {

    private static List<Integer> ans = new ArrayList<>();


    public static void main(String[] args) {
        BinaryTree node1 = new BinaryTree(1);
        BinaryTree node2 = new BinaryTree(2);
        BinaryTree node3 = new BinaryTree(3);
        BinaryTree node4 = new BinaryTree(4);
        BinaryTree node5 = new BinaryTree(5);
        BinaryTree node6 = new BinaryTree(6);
        BinaryTree node7 = new BinaryTree(7);
        BinaryTree node8 = new BinaryTree(8);
        BinaryTree node9 = new BinaryTree(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.right = node9;
        node5.left = node8;
        System.out.println(distanceK(node1, node2, 2));
    }

    public static List<Integer> distanceK(BinaryTree root, BinaryTree target, int k) {
        childNodes(target, k);
        otherNodes(root, target, k);
        return ans;
    }

    public static int otherNodes(BinaryTree root, BinaryTree target, int k) {
        if(root == target) {
            return k;
        }
        if(root == null) {
            return -1;
        }
        int left = otherNodes(root.left, target, k);
        if(left > 1) {
            childNodes(root.right, left-2);
            return left - 1;
        } else if(left == 1) {
            ans.add(root.val);
            return -1;
        }

        int right = otherNodes(root.right, target, k);
        if(right > 1) {
            childNodes(root.left, right-2);
            return right - 1;
        } else if(right == 1) {
            ans.add(root.val);
            return -1;
        }
        return -1;
    }

    public static void childNodes(BinaryTree target, int k) {

        if(k == 0 && target != null) {
            ans.add(target.val);
            return;
        }
        if(target == null || k < 0) {
            return;
        }

        if(target.left != null) {
            childNodes(target.left, k-1);
        }
        if(target.right != null) {
            childNodes(target.right, k-1);
        }
    }

}
