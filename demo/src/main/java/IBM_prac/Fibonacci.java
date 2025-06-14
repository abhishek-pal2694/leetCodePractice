package IBM_prac;

import java.util.stream.IntStream;

public class Fibonacci {

    private static int counter = 0;
    public static void main(String[] args) {
//        double res = Math.abs(3+4/2);
//        System.out.println(res);
        //System.out.println(IntStream.range(0,5).map(Fibonacci::factorial).boxed().collect(Collectors.toList()));
        //System.out.println("result: "+Fibonacci.reccur(3, new int[4]));

        for(int range=0; range<5; range++){
//            System.out.println(Fibonacci.normalRecur(range));
//            System.out.println(Fibonacci.reccur(range,new int[range+1]));
            System.out.println(Fibonacci.tabulation(range,new int[range+1]));
        }
        System.out.println("counter: "+counter);
    }

    private static int reccur(int index, int[] memo){
        counter++;
//        System.out.println(memo[index]);
        if(index <=1) return index;
        if(memo[index]!=0) return memo[index];
        return memo[index] = reccur(index -1, memo) + reccur(index -2, memo);
    }

    private static int normalRecur(int range){
        counter++;
        if(range <= 1) return range;
        return normalRecur(range -1) + normalRecur(range-2);
    }

    private static int tabulation(int range, int[]dp){
        for(int i=0; i<=range;i++){
            if(i<=1){
                dp[i] = 1;
                continue;
            }

            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[range];
    }
}
