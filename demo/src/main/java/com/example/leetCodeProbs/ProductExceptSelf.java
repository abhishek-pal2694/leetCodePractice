package com.example.leetCodeProbs;

import java.util.Arrays;

/**
 Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

 The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

 You must write an algorithm that runs in O(n) time and without using the division operation.



 Example 1:

 Input: nums = [1,2,3,4]
 Output: [24,12,8,6]
 Example 2:

 Input: nums = [-1,1,0,-3,3]
 Output: [0,0,9,0,0]
 **/
public class ProductExceptSelf {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }
    public static int[] productExceptSelf(int[] nums) {
        int i = 0;
        int temp = 0;
        int prod = 1;
        int[] ans = new int[nums.length];
        while (i<nums.length){
            if(temp==nums.length){
                ans[i] = prod;
                temp = 0;
                prod = 1;
                i++;
                continue;
            }
            if(nums[i]==nums[temp]){
                temp++;
                continue;
            }
            prod *= nums[temp];
            temp++;
        }
        return ans;
    }
}
