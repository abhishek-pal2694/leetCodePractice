package leetCode75;

import java.util.HashMap;
import java.util.Map;

public class MinJumps {

    public static void main(String[] args) {
        System.out.println(minJumps(new int[]{1, 4, 3, 2, 6, 7}));
    }
    static int minJumps(int[] arr) {
        // code here
        int maxReach = 0;
        int count = 0;
        int curr = 0;
        for(int i=0; i<arr.length; i++){
            maxReach = Math.max(maxReach, i+arr[i]);
            if(i==curr){
                curr = maxReach;
                count++;
            }
        }
        if(count==0){
            return -1;
        };

        return count;

    }
}
