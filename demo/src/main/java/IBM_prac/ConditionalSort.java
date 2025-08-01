package IBM_prac;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ConditionalSort {

    public static void main(String[] args) {
        sort(new int[]{29, 40, 20, -2, 0, -5, 24, 25, -3, 44, 33, 24, 29, 38});
    }

    //[29, 40, 20, -2, 0, -5, 24, 25, -3, 44, 33, 24, 29, 38]
    public static int[] sort(int[] input){
        List<Integer> collect = Arrays.stream(input).boxed().filter(num -> num > 0)
                .collect(Collectors.groupingBy(num -> num, TreeMap::new, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey).toList();

        int j =0;
        for(int i=0; i<input.length;i++){
            if(collect.contains(input[i])){
                input[i] = collect.get(j++);
            }
        }
        Arrays.stream(input).forEach(x-> System.out.print(x + " "));

        return input;
    }
}
