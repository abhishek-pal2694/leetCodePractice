package com.example.leetCodeProbs;

public class CamelCasing {
    public static void main(String[] args) {
        //String input = "this_is_test_input";
        String input = "thisIsTestInput";
        String output = "";
        for (int i=0; i<input.length();i++){
            if(input.charAt(i) == '_'){
                output += Character.toUpperCase(input.charAt(++i));
                i++;
            }if(Character.isUpperCase(input.charAt(i))){
                output += "_"+ Character.toLowerCase(input.charAt(i));
            }else{
                output += input.charAt(i);
            }
        }
        System.out.println(output);
    }
}
