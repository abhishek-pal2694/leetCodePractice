package leetCode75;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseVowels {

    public static void main(String[] args) {
        System.out.println(reverseVowels(" LLa")); // output expected = AceCreIm
    }

    public static String reverseVowels(String s) {
        char[] characs = s.toCharArray();
        int start = 0;
        int end = characs.length-1;
        while(start<end){
            if(!isVowel(characs[start])){
                start++;
            }
            else if(!isVowel(characs[end])){
                end--;
            }
            else{
                char temp = characs[start];
                characs[start] = characs[end];
                characs[end] = temp;
                start++;
                end--;
            }
        }
        return new String(characs);
    }

    private static boolean isVowel(char c){
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }
}
