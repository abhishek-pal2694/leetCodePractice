package leetCode75;


import java.util.*;

/*Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.



Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]*/
public class TopKFrequent {

    public static void main(String[] args) {
        System.out.println("output--> "+ Arrays.toString(getTopKUsingHeap(new int[]{1, 1, 1, 2, 2, 3,3,3,3}, 2)));
    }

    public static int[] getTopKUsingHeap(int[] input, int k){
        Map<Integer,Integer> freqMap = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            freqMap.put(input[i], freqMap.getOrDefault(input[i], 0)+1);
        }
        System.out.println(freqMap);
        PriorityQueue<Map.Entry<Integer,Integer>> heap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for(Map.Entry<Integer,Integer> entry : freqMap.entrySet()){
            heap.add(entry);
            if(heap.size()> k){
                heap.poll();
            }
        }

        int[] output = new int[k];
        int i = 0;
        while(i<k && !heap.isEmpty()){
            output[i] = heap.poll().getKey();
            i++;
        }
        return output;
    }

    public static int[] getTopK(int[] input, int k){
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int num: input){
            freqMap.put(num, freqMap.getOrDefault(num,0)+1); // map created:{num: freq} : {1:3, 2:2, 3:1}
        }

        // we will do bucket sort now : This step will populate the bucket
        // create a bucket where each element will be a list and index will be frequency
        List<Integer>[] bucket = new List[input.length+1];
        for(Map.Entry<Integer,Integer> map: freqMap.entrySet()){
            if(bucket[map.getValue()] ==null){
                bucket[map.getValue()] = new ArrayList<>();
            }
            bucket[map.getValue()].add(map.getKey());
        }
        System.out.println(Arrays.toString(bucket));  // [null, [3], [2], [1], null, null, null]

        int[] output = new int[k];
        int count = 0;
        for(int j= bucket.length-1; j>=0 & count<k; j--){
            if(bucket[j]!=null){
                for(int num: bucket[j]){
                    output[count++] = num;
                }
            }
        }
        return output;
    }
}
