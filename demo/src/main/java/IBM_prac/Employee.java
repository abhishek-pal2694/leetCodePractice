package IBM_prac;

public class Employee {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    String name;
    double salary;

    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
    }
}
