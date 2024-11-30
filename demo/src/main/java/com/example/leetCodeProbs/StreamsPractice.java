package com.example.leetCodeProbs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsPractice {

    public static void main(String[] args) {

        int[] array1 = new int[]{1,2,3,4,5,6};
        int[] array2 = new int[]{7,2,8,4,9,6};

        int[] common = Arrays.stream(array1).filter(num -> Arrays.stream(array2).anyMatch(x -> x == num)).toArray();
        Arrays.stream(common).forEach(System.out::println);

        //Given a list of integers, filter out the even numbers and double the remaining ones
        List<Integer> numList = Arrays.asList(1,4,5,7,8,3,4);
        Predicate<Integer> even = i -> i % 2 != 0;
        List<Integer> integers = numList.stream().filter(even).map(x -> 2 * x).collect(Collectors.toList());
        //System.out.println(integers);
        List<Integer> limitCollect = numList.stream().limit(2).collect(Collectors.toList());
        System.out.println("limitCollect: "+limitCollect);

        Integer max = numList.stream().max(Integer::compareTo).get();
        System.out.println(max);

        Integer secondMax = Arrays.stream(array1).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println("secondMax: "+ secondMax);

        Integer sum = numList.stream().reduce(Integer::sum).get();
        System.out.println("sum -->" + sum);

        double average = numList.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println("average-->" + average);

        //Given a list of names, group them by the starting letter and count the number of names that start with each letter.
        List<String> names = Arrays.asList("Abhi","Any","Noni","Naani","Niisss");
        Map<Character, Long> collect = names.stream().collect(Collectors.groupingBy(x -> x.charAt(0), Collectors.counting()));
        System.out.println("nameMap--->"+ collect);

        //Given a list of strings, concatenate them all into a single string using streams.
        String reduce = names.stream().reduce("", String::concat);
        System.out.println("concatenated --->" + reduce);

        Map<Integer, Long> collect1 = numList.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));


        List<Integer> distinctList = numList.stream().distinct().collect(Collectors.toList());
        System.out.println("distinctList -->" + distinctList);

        List<String> sortedNames = names.stream().sorted().collect(Collectors.toList());
        System.out.println("sortedString--->" + sortedNames);



        //Given a list of numbers, partition them into two lists - one with even numbers and one with odd numbers using streams.
        Map<Boolean, List<Integer>> booleanListMap = numList.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0));
        System.out.println("evenList --> "+ booleanListMap.get(true));

        //Find the common elements between two lists using streams.
        List<String> names2 = Arrays.asList("Abhi","HHII","Noni","MNAU","Niisss");
        List<String> commonString = names2.stream().filter(n -> names.contains(n)).collect(Collectors.toList());
        System.out.println("commonString--> "+ commonString);










        String input = "jad_ja_sda"; //convert this to camelcase
        char[] inputCharArray = input.toCharArray();
        Arrays.sort(inputCharArray);


//        char[] chars = input.toCharArray();
//        for (char word: chars
//             ) {
//            if(word)
//        }
    }
}
