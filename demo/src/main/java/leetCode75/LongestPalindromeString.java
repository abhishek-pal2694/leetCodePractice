package leetCode75;


/*Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
*/
public class LongestPalindromeString {

    public String longestPalindrome(String s) {
        String longestPal = !s.isEmpty()? s.substring(0,1): "";

        for(int i=0; i<s.length();i++){
            String evenString = expandPalindrome(s, i, i+1);
            String oddString = expandPalindrome(s,i,i);
            if(evenString.length()>longestPal.length()){
                longestPal = evenString;
            }
            if(oddString.length()>longestPal.length()){
                longestPal = oddString;
            }
        }

        return longestPal;
    }

    public String expandPalindrome(String s, int start, int end){
        while(start>=0 && end<s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        return s.substring(start+1, end); // start + 1 because we are going till 0 for start and the looping out
    }
}
