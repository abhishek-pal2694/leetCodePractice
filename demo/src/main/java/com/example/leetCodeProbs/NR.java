package com.example.leetCodeProbs;

import java.util.*;
import java.util.stream.Collectors;

public class NR {
    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
//        System.out.println(nonRepeating("abcab")); // should return 'c'
//        System.out.println(nonRepeating("abab")); // should return null
//        System.out.println(nonRepeating("aabbbc")); // should return 'c'
        System.out.println(returnIndexofNR("aabbdbc")); // should return 'd'
    }

    // Implement your solution below.
    public static Character nonRepeating(String s) {
        Map<String, Long> collect = Arrays.stream(s.split("")).collect(Collectors.groupingBy(word -> word, LinkedHashMap::new, Collectors.counting()));
        Map.Entry<String, Long> key = collect.entrySet().stream().filter(stringLongEntry -> stringLongEntry.getValue() ==1).findFirst().orElse(null);

        return Objects.isNull(key) ? null: key.getKey().charAt(0);
    }

    public static int returnIndexofNR(String s){
        for (int i = 0; i < s.length(); i++) {
            if(s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))){
                return i;
            }
        }
        return -1;
    }
}
