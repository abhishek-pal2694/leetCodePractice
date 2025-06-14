package leetCode75;

import java.util.Set;

//Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
//
//Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
//
//
//
//Example 1:
//
//Input: s = "abciiidef", k = 3
//Output: 3
//Explanation: The substring "iii" contains 3 vowel letters.
//Example 2:
//
//Input: s = "aeiou", k = 2
//Output: 2
//Explanation: Any substring of length 2 contains 2 vowels.
//        Example 3:
//
//Input: s = "leetcode", k = 3
//Output: 2
//Explanation: "lee", "eet" and "ode" contain 2 vowels.
public class MaxNumberVowels {

    public static void main(String[] args) {
        MaxNumberVowels maxNumberVowels = new MaxNumberVowels();
        System.out.println(maxNumberVowels.maxVowels("abciiidef", 3));
    }

    public int isVowel(Character c){
        return (c=='a' || c=='e' || c=='i' || c=='o' || c=='u') ? 1: 0;
    }
    public int maxVowels(String s, int k) {
        int maxVowel = 0, left = 0, right = 0;
        int count = 0;
        for (; right < k; right++) {
            count += isVowel(s.charAt(right));
        }
        maxVowel = count;

        while(right<s.length()){
            count -= isVowel(s.charAt(left++));
            count += isVowel(s.charAt(right++));
            maxVowel = Math.max(count, maxVowel);
        }

        return maxVowel;
    }
}
