package com.ds.algo.one;

import java.util.Arrays;

public class SolutionService4 {

    public static int min = 0;

    public static void main(String[] args) {
        double[] start = {9.00, 9.40, 9.50, 11.00, 15.00, 18.00} ;
        double[] end = {9.10, 12.00, 11.20, 11.30, 19.00, 20.00} ;
        findMinPlatformNo(start, end);
        System.out.println("Min Platform Required: " + min);
        min = 0;
        findMinPlatformNo_V2(start, end);
        System.out.println("Min Platform Required V2: " + min);
    }

    public static void findMinPlatformNo(double[] start, double[] end) {
        for (int i = 0; i < start.length; i++) {
            int count = 1;
            for (int j = i+1; j < start.length; j++) {
                if((start[i] >= start[j] && start[i] <= end[j])
                ||(start[i] <= start[j] && end[i] >= start[j])) {
                    count++;
                }
            }
            if(count >= min) {
                min = count;
            }
        }
    }

    public static void findMinPlatformNo_V2(double[] start, double[] end) {
        Arrays.sort(start);
        Arrays.sort(end);
        int i = 1, j = 0, count = 1;
        while (i < start.length && j < start.length) {
            if(start[i] <= end[j]) {
                count++;
                i++;
            } else if(start[i] > end[j]) {
                count--;
                j++;
            }

            if(count >= min) {
                min = count;
            }
        }
    }

}
