package com.example.leetCodeProbs;

import java.util.Stack;

public class BalancedParanthesis {

    public static void main(String[] args) {

        System.out.println(isValid("()[]{}"));
    }

    public static boolean isValid(String s) {
        Stack<Character> check = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ')' && check.peek() == '('){
                check.pop();
            }else if(s.charAt(i) == ']' && check.peek() == '['){
                check.pop();
            }else if(s.charAt(i) == '}' && check.peek() == '{'){
                check.pop();
            }else  {
                check.push(s.charAt(i));
            }

        }
        if(!check.empty()){
            System.out.println(check.peek().charValue());
            return false;
        }
        return true;

    }
}
