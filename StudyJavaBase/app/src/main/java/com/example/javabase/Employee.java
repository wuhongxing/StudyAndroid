package com.example.javabase;

public class Employee {
    String name;
    int age;
    String designation;
    double salary;

    public  Employee(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public  void printEmployee() {
        System.out.print("名字：" + name);
        System.out.print("年纪：" + age);
        System.out.print("职位：" + designation);
        System.out.print("薪水：" + salary);
    }
}
