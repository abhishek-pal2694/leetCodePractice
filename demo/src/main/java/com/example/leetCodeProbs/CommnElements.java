package com.example.leetCodeProbs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CommnElements {

    public static void main(String[] args) {

        int[] array1A = {1, 3, 4, 6, 7, 9};
        int[] array2A = {1, 2, 4, 5, 9, 10};

        Arrays.stream(array1A).forEach(System.out::print);
        Collections.reverse(Arrays.asList(array1A));
        System.out.println("after reversing");
        Arrays.stream(array1A).forEach(System.out::print);

        List<Integer> collect = Arrays.stream(array2A).boxed().filter(num -> Arrays.stream(array1A).anyMatch(n -> n == num)).collect(Collectors.toList());
        System.out.println(collect);
    }
}
