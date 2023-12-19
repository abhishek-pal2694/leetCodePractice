package com.example.leetCodeProbs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class MF {
    public static void main(String[] args) {
        // NOTE: The following input values are used for testing your solution.

        // mostFrequent(array1) should return 1.
        int[] array1 = {1, 3, 1, 3, 2, 1};
        // mostFrequent(array2) should return 3.
        int[] array2 = {3, 3, 1, 3, 2, 1};
        // mostFrequent(array3) should return null.
        int[] array3 = {};
        // mostFrequent(array4) should return 0.
        int[] array4 = {0};
        // mostFrequent(array5) should return -1.
        int[] array5 = {0, -1, 10, 10, -1, 10, -1, -1, -1, 1};

        mostFreqent(array5);
    }

    // Implement your solution below.
    public static Integer mostFreqent(int[] givenArray) {
        Map<Integer, Long> collect = Arrays.stream(givenArray).boxed().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        System.out.println(collect.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getKey());
        return collect.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getKey();
    }
}
