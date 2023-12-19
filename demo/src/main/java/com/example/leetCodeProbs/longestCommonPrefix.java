package com.example.leetCodeProbs;

import java.util.Arrays;

public class longestCommonPrefix {
    public static void main(String[] args) {
        findLongestPrefix(new String[]{"Abhign", "Abhishek", "AbhiJeet"});
    }

    private static void findLongestPrefix(String[] strings) {
        int minLength = strings[0].length();
        for (int i=0; i<strings.length;i++){
            if(minLength > strings[i].length()){
                minLength = strings[i].length(); // taking the length of the smallest string
            }
        }

        String prefix = strings[0].substring(0,minLength);

        for (String word: strings
             ) {
            while(!word.startsWith(prefix)){
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }

//        for(int i = 0; i< strings.length; i++){
//            while (!strings[i].startsWith(prefix)){
//                prefix = prefix.substring(0, prefix.length()-1);
//            }
//        }
        System.out.println(prefix);

    }
}
