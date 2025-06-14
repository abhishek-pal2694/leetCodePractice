package leetCode75;

public class MaxSubArray {

    public static void main(String[] args) {
        int i = maxSubarraySum(new int[]{1, 2, 3, -2, 5});
        System.out.println(i);
    }

    static int maxSubarraySum(int[] arr) {
        // Your code here
        int sum = 0;
        int maxSum = arr[0];

        for(int i=0; i<arr.length;i++){
            sum = sum + arr[i];
            if(sum<=0){
                sum = 0;
            }
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}
