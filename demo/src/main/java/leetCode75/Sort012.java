package leetCode75;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Sort012 {

    public static void main(String[] args) {
        int[] input = new int[]{1,2,0,0,1,1,2};
        sort012(input);
        System.out.println(Arrays.toString(input));
    }

    // Function to sort an array of 0s, 1s, and 2s
    public static void sort012(int[] arr) {
        // code here
        Map<Integer, Integer> freqMap = new TreeMap<>();
        for(int num: arr){
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }
        System.out.println(freqMap);
        int index = 0;
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            while(index<arr.length && entry.getValue()>0){
                arr[index++] = entry.getKey();
                freqMap.put(entry.getKey(), freqMap.get(entry.getKey())-1);
            }
        }
    }
}
