package leetCode75;

import java.util.Arrays;
import java.util.List;

public class CanPlaceFlowers {

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1, 0, 0}, 2));
    }
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed.length<n) return false;

        for (int i=0; i<flowerbed.length;i++){
            if(flowerbed[i] != 1) {
                boolean left = i == 0 || flowerbed[i - 1] == 0;
                boolean right = i == flowerbed.length-1 || flowerbed[i+1] ==0;
                if(left && right){
                    flowerbed[i] = 1;
                    n = n-1;
                    if(n==0) return true;
                }
            }
        }
        return false;
    }
}
