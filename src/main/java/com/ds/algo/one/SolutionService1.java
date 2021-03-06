package com.ds.algo.one;

import java.util.ArrayList;
import java.util.List;

public class SolutionService1 {

    public static void main(String[] args) {

        SolutionService1 service = new SolutionService1();
        boolean result = service.isCompleteTree(service.getInput());
        System.out.println("Result: " + result);

    }

    List<TreeNode> first = new ArrayList<TreeNode>();
    List<TreeNode> second = new ArrayList<TreeNode>();

    public boolean isCompleteTree(TreeNode root) {

        if (root == null) {
            return true;
        }

        first.add(root.left);
        first.add(root.right);

        return check(first, second, true);

    }

    public boolean check(List<TreeNode> first, List<TreeNode> second, boolean flagFirst) {

        boolean flagNullAtLevel = false;
        boolean flagAnyNotNullAtLevel = false;

        boolean breakFlag = false;

        while (!breakFlag) {

            if (first.size() == second.size() && first.size() == 0) {
                breakFlag = true;
            } else if (flagFirst) {
                for (int i = 0; i < first.size(); i++) {

                    if (flagNullAtLevel && first.get(i) != null) {
                        return false;
                    }

                    if (first.get(i) == null) {
                        flagNullAtLevel = true;
                    } else {
                        if (first.get(i).left != null || first.get(i).right != null) {
                            flagAnyNotNullAtLevel = true;
                        }
                        second.add(first.get(i).left);
                        second.add(first.get(i).right);
                    }

                }
                if (flagNullAtLevel && flagAnyNotNullAtLevel) {
                    return false;
                }
                flagFirst = false;
                flagNullAtLevel = false;
                flagAnyNotNullAtLevel = false;
                first.clear();

            } else {
                for (int i = 0; i < second.size(); i++) {

                    if (flagNullAtLevel && second.get(i) != null) {
                        return false;
                    }

                    if (second.get(i) == null) {
                        flagNullAtLevel = true;
                    } else {
                        if (second.get(i).left != null || second.get(i).right != null) {
                            flagAnyNotNullAtLevel = true;
                        }
                        first.add(second.get(i).left);
                        first.add(second.get(i).right);
                    }

                }
                if (flagNullAtLevel && flagAnyNotNullAtLevel) {
                    return false;
                }
                flagFirst = true;
                flagNullAtLevel = false;
                flagAnyNotNullAtLevel = false;
                second.clear();
            }
        }
        return true;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode getInput() {
        TreeNode node1 = new TreeNode(1);

        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;

        return node1;
    }

}
