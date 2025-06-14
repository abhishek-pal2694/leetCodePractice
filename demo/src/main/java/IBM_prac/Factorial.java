package IBM_prac;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(3));
    }

    private static int factorial(int num){
        if(num ==1) return num;
        return num * factorial(num-1);
    }
}
