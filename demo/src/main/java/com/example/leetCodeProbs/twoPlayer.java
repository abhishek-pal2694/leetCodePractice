package com.example.leetCodeProbs;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class twoPlayer {
    public static void main(String[] args) {
        System.out.println(findDifference(Arrays.asList(3,2,6)));
    }

    private static Long findDifference(List<Integer> asList) {
        int firstNum = 1;
        int secondNum = 1;
        boolean secondPlayer = false;
        List<Integer> modList = new CopyOnWriteArrayList<>();
        for(Integer num : modList){
            if(!secondPlayer){
                firstNum *= num;
                secondPlayer = true;
            }else {
                secondNum *= num;
                secondPlayer = false;
            }
            modList.remove(num);
            if(!modList.isEmpty()){
                if(num%2==0){
                    Collections.reverse(modList);
                }
            }
        }
        return Long.valueOf(firstNum - secondNum);
    }
}
