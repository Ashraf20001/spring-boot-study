package com.problems.stream_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CategorizeBasedOnSalary {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Mani",3000.0));
        employees.add(new Employee("Hari",2000.0));
        employees.add(new Employee("Sori",1000.0));
        employees.add(new Employee("Puri",5000.0));
        employees.add(new Employee("Lori",6000.0));
        employees.add(new Employee("Juri",7000.0));


        System.out.println(employees.stream().collect(Collectors.groupingBy(emps->CategorizeBasedOnSalary.categorize(emps.getSalary()))));

    }

    private static String categorize(Double salary){
        if(salary<=2000.0){
            return "Low";
        } else if (salary>2000.0 && salary<=5000.0) {
            return "Medium";
        } else {
            return "High";
        }
    }
}

class Employee {

    String name;
    Double salary;

    public Employee(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
