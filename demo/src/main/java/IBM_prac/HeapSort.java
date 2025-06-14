package IBM_prac;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] input = new int[]{1,12,9,5,6,10};
        heapSort(input);
    }

    public static void heapSort(int[] input){

        int n = input.length;

        System.out.println("list befor heapify: "+ Arrays.toString(input));
        // create a max heap
        for(int i=n/2 - 1; i>=0; i--){ // (n/2 -1) This is to find the non leaf node
            heapify(input, n, i);
        }
//        System.out.println("list after heapify: "+ Arrays.toString(input));

        //create min heap
//        for(int i=0; i>=n/2 - 1; i++){ // (n/2 -1) This is to find the non leaf node
//            heapify(input, n, i);
//        }

        System.out.println("list after heapify: "+ Arrays.toString(input));

        for (int i = n-1; i>0 ; i--) {
            swap(i,0,input);
            heapify(input,i,0);

        }

        System.out.println("list after sorting: "+ Arrays.toString(input));
    }

    private static void heapify(int[] input, int n, int i) {

        // Below are the formula to get left and right nodes of a heap
        int largeIndex = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        // this part is responsible for max or min heap for max > for min <
        if(left<n && input[left]>input[largeIndex]){
            largeIndex = left;
        }
        if (right<n && input[right]>input[largeIndex]) {
            largeIndex = right;
        }

        if(largeIndex!=i){
            swap(largeIndex,i,input);
            heapify(input,n,largeIndex);
        }
    }

    private static void swap(int largeIndex, int i, int[] input) {
        int temp = input[largeIndex];
        input[largeIndex] = input[i];
        input[i] = temp;
    }
}
