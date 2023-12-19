package com.example.leetCodeProbs;

import java.util.*;

public class ReverseString {
    public static void main(String[] args) {
        String word = "Hello";
        //char[] words = word.toCharArray();
        String[] words = word.split("");
        System.out.println(words[0]);
        Stack<String> st = new Stack<>();
        for (String w: words
             ) {
            st.push(w);
        }
        int i =0;
        while (!st.isEmpty()){
            words[i++] = st.pop();
        }
        String output = "";
        for (int j =0; j<words.length; j++) {
            output += words[j];
            System.out.println("reversed ---> " + words[j]);
        }
        System.out.println(output);
        Map<String,String> numMap = new HashMap<>();
        int k = 0 , j =0;


    }
}
