package com.example.leetCodeProbs;

public class MajorityElement2 {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,3,4}));
    }

    public static int majorityElement(int[] nums) {
        int i = 0 , j =0;
        int maxCount = 0;
        int majorElement = nums[0];
        int numCount = 0;
        while (j<nums.length){
            if(nums[j] == nums[i]){
                numCount++;
            }
            //i++;
            if(numCount > maxCount){
                maxCount = numCount;
                majorElement = nums[j];
            }
            if(++i == nums.length){
                j++;
                i = 0;
                numCount =0;
            }
        }
        return majorElement;
    }
}
