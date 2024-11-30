package com.example.leetCodeProbs;

//Example 1:
//
//Input: str1 = "ABCABC", str2 = "ABC"
//Output: "ABC"
//Example 2:
//
//Input: str1 = "ABABAB", str2 = "ABAB"
//Output: "AB"
//Example 3:
//
//Input: str1 = "LEET", str2 = "CODE"
//Output: ""
public class GreatestCommonDivisor {

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABABAB","ABAB"));
    }

    public static String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)){
            return "";
        }
        return str1.substring(0,gcd(str1.length(), str2.length()));

    }
    private static int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a%b);
    }
}
