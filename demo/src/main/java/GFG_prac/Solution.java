package GFG_prac;

import java.util.ArrayList;

class Solution {

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{12,18,5,11,30,5}, 69));
    }

    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        ArrayList<Integer> output = new ArrayList<>();
        int right = 0;
        int sum = 0;
        for(int left=0; left<arr.length; left++){
            if(sum == target){
                output.add(left);
                output.add(right);
                return output;
            }
            while(right<arr.length && sum<target){
                sum += arr[right];
                right++;
            }
            if(sum>target){
                sum -= arr[left];
            }
        }
        output.add(-1);
        return output;
    }
}