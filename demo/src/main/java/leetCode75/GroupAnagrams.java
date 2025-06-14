package leetCode75;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> resultMap = new HashMap<>();
        for(String word : strs){
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
//            if(!resultMap.containsKey(sorted)){
//                resultMap.put(sorted, new ArrayList<>());
//            }
            resultMap.putIfAbsent(sorted,new ArrayList<>());
            resultMap.get(sorted).add(word);

        }

        List<Integer> intList = new ArrayList<>();
        Map<Integer,List<Integer>> res = new HashMap<>();
        int[] ints = intList.stream().mapToInt(Integer::intValue).toArray();


        return new ArrayList<>(resultMap.values());
    }

}
