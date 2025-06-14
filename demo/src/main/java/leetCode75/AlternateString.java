package leetCode75;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//You are given two strings word1 and word2. Merge the strings by adding letters in alternating order,
// starting with word1.
// If a string is longer than the other, append the additional letters onto the end of the merged string.
public class AlternateString {

    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc","pqrabst"));
    }
    public static String mergeAlternately(String word1, String word2) {
        Map<String, List<String>> resultMap = new HashMap<>();
        char[] sorted = word2.toCharArray();
        Arrays.sort(sorted);
        String out = new String(sorted);
        System.out.println("out-->"+out);
        StringBuilder output = new StringBuilder();
        int i = 0;
        while(i<word1.length() && i<word2.length()){
            output.append(word1.charAt(i)).append(word2.charAt(i));
            i++;
        }
        while (i<word1.length()){
            output.append(word1.charAt(i++));
        }
        while (i<word2.length()){
            output.append(word2.charAt(i++));
        }
        return output.toString();
    }
}
