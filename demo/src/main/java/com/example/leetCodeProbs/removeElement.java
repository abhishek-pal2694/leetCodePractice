package com.example.leetCodeProbs;

import java.util.Arrays;

public class removeElement {

    public static void main(String[] args) {
        removeElement(new int[]{0,1,2,2,3,0,4,2}, 2);
    }

    public static int removeElement(int[] nums, int val) {
        int count = 0;
        int[] res = new int[nums.length];
        int j =0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == val){
                count++;
            }else{
                res[j++] = nums[i];
            }
        }
        nums = res;
        Arrays.stream(nums).forEach(System.out::println);
        System.out.println("count ---> "+ count);
        return count;
    }
}
