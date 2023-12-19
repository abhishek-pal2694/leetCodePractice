package com.example.leetCodeProbs;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class dsPracticeCodes {

    public static void main(String[] args) {
        int[] input = {4,6,3,7,1,35,22};
//        bubbleSort(input);
//        selectionSort(input);
        insertionSort(input);
    }

    // This sorting algorithm is optimal when the array is almost sorted
    private static void insertionSort(int[] input) {
        for(int i =1; i<input.length; i++){
            int j = i-1;
            int temp = input[i];
            while (j>-1 && input[j] > input[j+1]){
                input[j+1] = input[j];
                input[j] = temp;
                j--;
            }
        }
        System.out.println("insertion Sort--> "+ Arrays.toString(input));
    }

    private static void bubbleSort(int[] input) {
        long start = System.nanoTime();
        for(int i = input.length-1; i>0; i--){
            for(int j= 0; j<i; j++){
                if(input[j] > input[j+1]){
                    int temp = input[j+1];
                    input[j+1] = input[j];
                    input[j] = temp;
                }
            }
        }
        long end = System.nanoTime();
        System.out.println("bubble sort--->" + Arrays.toString(input) + "executed in-->" + (start-end));
    }

    private static void selectionSort(int[] input) {
        long start = System.nanoTime();
        for(int i = 0; i<input.length; i++){
            int minIndex = i;
            for(int j = i+1; j<input.length; j++){
                if(input[j]< input[minIndex]){
                    minIndex = j;
                }
            }
            if (minIndex != i){
                int temp = input[i];
                input[i] = input[minIndex];
                input[minIndex] = temp;
            }
        }
        long end = System.nanoTime();
        System.out.println("Selection sort--->" + Arrays.toString(input) + "executed in-->" + (end-start));
    }

//    private static void zeroesAtend() {
//        List input = Arrays.asList(1, 0, 4, 0, 12, 9);
//        System.out.println(input.stream().sorted(Comparator.).collect(Collectors.toList()));
//    }

}
