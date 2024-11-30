package com.example.leetCodeProbs;

import java.io.IOException;

public class BinarySearch {
    public static void main(String[] args) {
        int i = doBinarySearch(new int[]{2, 5, 6, 8, 9, 10}, 5);
        System.out.println(i);
    }

    protected String testMethod() throws RuntimeException {
        System.out.println("test");
        return "tets";
    }

    public static int doBinarySearch(int[] num, int target){
        int firsIndex = 0;
        int lastIndex = num.length -1;

        while (firsIndex <= lastIndex){
            int middleIndex = (firsIndex + lastIndex) / 2;
            if(num[middleIndex] == target) return middleIndex;
            if(num[middleIndex] < target)
                firsIndex = middleIndex + 1;
            else
                lastIndex = middleIndex -1;
        }
        return -1;
    }
}
