package com.example.leetCodeProbs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrimeNumber {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,3,4,8,2,5,9,11,22,17);
        List<Integer> primeList = numbers.stream().filter(PrimeNumber::isPrime).collect(Collectors.toList());
        System.out.println(primeList);

    }

    private static boolean isPrime(Integer num){
        if(num <= 1){
            return false;
        }
        if(num%2 != 0) {
            for (int i = 3; i < num / 2; i = i + 2) {
                if (num % i == 0) {
                    return false;
                }
            }
        }else{
            if(num==2){
                return true;
            }
            return false;
        }
//        for(int i=2; i<Math.sqrt(num); i++){
//            if(num%i==0){
//                return false;
//            }
//        }
        return true;
    }
}
