package com.example.leetCodeProbs;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class practice {

    static class Employee{
        private int id;
        private String name;
        private Integer Salary;
        private String department;
        private int age;

        public Employee(int id, String name, Integer salary, String department, int age) {
            this.id = id;
            this.name = name;
            Salary = salary;
            this.department = department;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getSalary() {
            return Salary;
        }

        public void setSalary(Integer salary) {
            Salary = salary;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public int getAge() {
            return age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return id == employee.id && age == employee.age && Objects.equals(name, employee.name) && Objects.equals(Salary, employee.Salary) && Objects.equals(department, employee.department);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, Salary, department, age);
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", Salary=" + Salary +
                    ", department='" + department + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();

        Employee employee1 = new Employee(1,"AA",2000000,"IT",22);
        Employee employee2 = new Employee(1,"AA",4000000,"IT",22);
        employeeList.add(employee1);
        employeeList.add(employee2);



        Map<String, List<Employee>> collect = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        Map<String, Employee> employeeMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
                        //employee -> employee.get().id
                        //employee -> employee.map(Employee::getSalary).orElse(0)
                        Optional::get

                )));
        System.out.println(collect);
        System.out.println("employeeMap--->"+employeeMap);

        Map<String, Integer> sumMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.collectingAndThen(
                        Collectors.summingInt(Employee::getSalary), Integer::intValue
                )));
        System.out.println("sumMap: "+sumMap);

        List<Employee> nonDuplicateList = employeeList.stream().distinct().collect(Collectors.toList());
        System.out.println("nonDuplicateList--->" + nonDuplicateList);
        Integer sumOfSalary = employeeList.stream().collect(Collectors.collectingAndThen(
                Collectors.summingInt(Employee::getSalary), Integer::intValue));
        System.out.println("SumOfSalary --> " + sumOfSalary);

        Map<String, Integer> integerMap = employeeList.stream().collect(Collectors.toMap(Employee::getDepartment,
                Employee::getSalary, Integer::min));
        System.out.println("integerMap: "+ integerMap);

        List<Integer> salaries = employeeList.stream().map(employee -> employee.getSalary()).collect(Collectors.toList());
        Integer aLong = salaries.stream().max(Comparator.comparing(Integer::intValue)).get();
        System.out.println(aLong);
        salaries.stream().min(Integer::max).get();

        Integer maxsalary = employeeList.stream().max(Comparator.comparing(Employee::getSalary)).get().getSalary();
        System.out.println("maxSal--> "+maxsalary);

        Integer secondHeighest = employeeList.stream().collect(Collectors.groupingBy(Employee::getSalary))
                .keySet().stream().sorted(Collections.reverseOrder())
                .collect(Collectors.toList()).get(1);

        Integer first = employeeList.stream().collect(Collectors.groupingBy(Employee::getSalary, TreeMap::new, Collectors.toList()))
                .keySet().stream().skip(1).findFirst().get();
        System.out.println(first);

        List<Employee> sortedList = employeeList.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());
    }





}
