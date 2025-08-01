package leetCode75;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        System.out.println(wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa")));
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        int start = 0;
        // Set<String> ref = new HashSet<>();
        boolean flag = false;
        for(int end=1; end<=s.length(); end++){
            String sub = s.substring(start,end);
            if(wordDict.contains(sub)){
                //ref.add(sub);
                flag = true;
                start = end;
            }else{
                flag = false;
            }
            Integer.MIN_VALUE
        }
        return flag;
    }
}