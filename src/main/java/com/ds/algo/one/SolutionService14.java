package com.ds.algo.one;

import java.util.Map;
import java.util.TreeMap;

public class SolutionService14 {

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
        rightView(node1);
    }

    private static class Tracker {
        public Integer value;
        public Integer distance;

        Tracker(Integer value, Integer distance) {
            this.distance = distance;
            this.value = value;
        }
    }

    private static void rightView(BinaryTree root) {
        if (root == null) {
            return;
        }
        TreeMap<Integer, Tracker> tracker = new TreeMap<>();
        rightView(root, 0, 0, tracker);

        for(Tracker pair : tracker.values()){
            System.out.print(pair.value+" ");
        }
    }

    private static void rightView(BinaryTree root, int dis, int level, Map<Integer, Tracker> tracker) {
        if (root == null) {
            return;
        }
        if (!tracker.containsKey(level) || dis < tracker.get(level).distance) {
            tracker.put(level, new Tracker(root.val, dis));
        }
        rightView(root.right, dis - 1, level + 1, tracker);
        rightView(root.left, dis + 1, level + 1, tracker);
    }
    
}
