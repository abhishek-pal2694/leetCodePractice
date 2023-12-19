package com.example.leetCodeProbs;

public class LengthOfLastString {

    public static void main(String[] args) {
        System.out.println(length("Test string"));

    }

    private static Integer length(String s){
        String[] s1 = s.split(" ");
        return s1[s1.length -1].length();
    }
}
