package IBM_prac;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {

        // sum of squares
        List<Integer> nums = List.of(2, 3);
        Integer reduce = nums.stream().map(num-> num*num).mapToInt(Integer::intValue).sum();
//        System.out.println(reduce);

        //Group strings by their length
        List<String> words = List.of("Java", "Spring", "Visa", "API", "REST");
        Map<Integer, List<String>> collect = words.stream().collect(Collectors.groupingBy(String::length));

//        System.out.println(collect);

        //Given a list of strings, count the frequency of each word.
        List<String> words2 = List.of("visa", "api", "visa", "payment", "api", "java");
        Map<String, Long> collect1 = words2.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        System.out.println(collect1);

        //Use Stream API to find the first non-repeating character in "visaapiservice"
        String test= "visaapiservice";
        String let = Arrays.stream(test.split("")).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream().filter(entry-> entry.getValue() == 1).findFirst().get().getKey();
        System.out.println(let);

//        Find the employee with the highest salary.
        List<Employee> empList = List.of(new Employee("third", 8000000),new Employee("first", 200000),
                new Employee("second", 6000000));
        Employee employee = empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).findFirst().get();
        System.out.println(employee.getName());

        //Return the top k most frequent words from a list.
        //Input: ["visa", "api", "visa", "payment", "api", "java"], k=2
        //Output: ["visa", "api"]

        List<String> inputList = List.of("visa", "api", "visa", "payment", "api", "java");
        List<String> res = inputList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().sorted(Comparator.comparing(Map.Entry<String,Long>::getValue, Comparator.reverseOrder()))
                .limit(2).map(Map.Entry::getKey).toList();
        System.out.println(res);
    }
}
