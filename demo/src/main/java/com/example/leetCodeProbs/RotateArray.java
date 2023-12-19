package com.example.leetCodeProbs;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] input = {1,2,3,4,5,6,7};
        rotate(input,3);
        System.out.println("output: ");
        Arrays.stream(input).forEach(System.out::print);
    }

    public static void rotate(int[] input, int k){
        int count = 1;
        while (count <=k){
            int[] rotatedArr = new int[input.length];
            rotatedArr[0] = input[input.length-1];
            for (int i = 0; i < input.length-1; i++) {
                rotatedArr[i+1] = input[i];
            }
            input = rotatedArr;
            count++;
            Arrays.stream(input).forEach(System.out::print);
            System.out.println("-----------");
        }
    }
}
