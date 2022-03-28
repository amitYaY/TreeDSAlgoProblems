package com.ds.algo.one;

import java.util.Map;
import java.util.TreeMap;

public class SolutionService12 {

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
        topView(node1);
    }

    private static class Tracker {
        public Integer value;
        public Integer level;

        Tracker(Integer value, Integer level) {
            this.level = level;
            this.value = value;
        }
    }

    private static void topView(BinaryTree root) {
        if (root == null) {
            return;
        }
        TreeMap<Integer, Tracker> tracker = new TreeMap<>();
        topView(root, 0, 0, tracker);

        for(Tracker pair : tracker.values()){
            System.out.print(pair.value+" ");
        }
    }

    private static void topView(BinaryTree root, int dis, int level, Map<Integer, Tracker> tracker) {
        if (root == null) {
            return;
        }
        if (!tracker.containsKey(dis) || level < tracker.get(dis).level) {
            tracker.put(dis, new Tracker(root.val, level));
        }
        topView(root.left, dis - 1, level + 1, tracker);
        topView(root.right, dis + 1, level + 1, tracker);
    }
}
