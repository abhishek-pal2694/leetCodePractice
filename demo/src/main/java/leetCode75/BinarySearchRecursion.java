package leetCode75;

public class BinarySearchRecursion {

    public static void main(String[] args) {
        System.out.println(search(new int[]{2,3,4,5,6,7},4));
    }

    public static int search(int[] nums, int target) {
        int first = 0;
        int last = nums.length-1;
        return binarySearch(first,last,nums,target);

    }

    private static int binarySearch(int first, int last, int[] nums, int target) {
        if(first>last) return -1;
        int middle = first+(last-first) / 2;
        if(nums[middle]==target) return middle;
        else if(nums[middle]>target){
            return binarySearch(first,middle -1,nums,target);
        }else{
            return binarySearch(middle +1,last,nums,target);
        }
    }
}
