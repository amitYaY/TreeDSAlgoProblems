package com.ds.algo.one;

import java.util.Arrays;

@SuppressWarnings("SpellCheckingInspection")
public class SolutionService16 {

    private static Integer[] maxHeap;
    private static int maxSize;
    private static int size = 0;

    /*
    Heap Tree is a Complete Binary Tree.
    Max Heap: Root is Max of all it's child.
    Min Heap: Root is Min of all it's child.
    In Array representation:
        Children of i: left= 2*i+1, right 2*i+2
        Parent of i: i-1/2
     */

    private static void insertValue(int val) {
        if (size == maxSize) {
            return;
        }
        if (size == 0) {
            maxHeap[size++] = val;
        } else {
            maxHeap[size++] = val;
            heapifyUpword(size - 1);
        }
    }

    private static Integer removeMax() {

        if (size == 0) {
            return null;
        }

        int valueHolder = maxHeap[0];
        maxHeap[0] = maxHeap[size-1];
        size--;
        if (size > 1) {
            heapifyDownword(0);
        }
        return valueHolder;
    }

    private static void heapifyDownword(int index) {
        int leftIndex = (index * 2) + 1;
        int rightIndex = (index * 2) + 2;

        if(leftIndex <= size) {
            if (maxHeap[leftIndex] > maxHeap[index] || maxHeap[rightIndex] > maxHeap[index]) {
                if (maxHeap[leftIndex] < maxHeap[rightIndex]) {
                    int valueHolder = maxHeap[rightIndex];
                    maxHeap[rightIndex] = maxHeap[index];
                    maxHeap[index] = valueHolder;
                    heapifyDownword(rightIndex);
                } else {
                    int valueHolder = maxHeap[leftIndex];
                    maxHeap[leftIndex] = maxHeap[index];
                    maxHeap[index] = valueHolder;
                    heapifyDownword(leftIndex);
                }
            }
        }
    }

    private static void heapifyUpword(int index) {
        int parentIndex = (index - 1) / 2;
        if (parentIndex >= 0) {
            if (maxHeap[parentIndex] < maxHeap[index]) {
                int valHolder = maxHeap[parentIndex];
                maxHeap[parentIndex] = maxHeap[index];
                maxHeap[index] = valHolder;
                heapifyUpword(parentIndex);
            }
        }
    }

    private static void printMaxHeap() {
        for (int i =0; i<size;i++) {
            System.out.print(maxHeap[i] + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        maxSize = 9;
        size = 0;
        maxHeap = new Integer[maxSize];
        Arrays.fill(maxHeap, null);
        insertValue(5);
        insertValue(3);
        insertValue(17);
        insertValue(10);
        insertValue(84);
        insertValue(19);
        insertValue(6);
        insertValue(22);
        insertValue(9);
        printMaxHeap();

        System.out.println(removeMax());
        System.out.println(removeMax());
        System.out.println(removeMax());
        System.out.println(removeMax());
        System.out.println(removeMax());
        System.out.println(removeMax());
        System.out.println(removeMax());
        System.out.println(removeMax());
        System.out.println(removeMax());
    }

}
