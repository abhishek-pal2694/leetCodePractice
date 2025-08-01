package com.example.leetCodeProbs;

import java.util.*;
import java.util.stream.Collectors;

public class AnagramCheck {

    //Input: String = ["eat","tea","tan","ate","nat","bat"]
//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

    public static void main(String[] args) {
        String[] input = {"eat","tea","tan","ate","nat","bat"};

        //System.out.println(isAnagram(input));

        System.out.println(anagramChecking("eat","tei"));

    }

    private static boolean anagramChecking(String in1, String in2) {
        char[] in1Arr = in1.toCharArray();
        char[] in2Arr = in2.toCharArray();
        Arrays.sort(in1Arr);
        Arrays.sort(in2Arr);
        for (int i = 0; i < in1Arr.length; i++) {
            if(in1Arr[i]!=in2Arr[i]){
                return false;
            }
        }
        return true;

    }


    public static List<List<String>> isAnagram(String[] input){

        Map<String, List<String>> outputMap = new HashMap<>();

        for(String word : input){
            String sorted = Arrays.stream(word.split("")).sorted().collect(Collectors.joining());
            if(!outputMap.containsKey(sorted)){
                outputMap.put(sorted, new ArrayList<>());
            }
            outputMap.get(sorted).add(word);
        }
        return new ArrayList<>(outputMap.values());



    }
}
