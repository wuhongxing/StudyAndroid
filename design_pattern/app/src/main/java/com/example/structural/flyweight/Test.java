package com.example.structural.flyweight;

public class Test {
    private static final String[] departments = {"AB", "CD", "EF", "GH"};
    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            String department = departments[(int) (Math.random() * departments.length)];
//            Manager manager = (Manager)EmployeeFactory.getManager(department);
//            manager.report();
//        }

        Integer a = 100;
        Integer b = 100;
        Integer c = 1000;
        Integer d = 1000;
        Integer e = Integer.valueOf(100);
        Integer f = Integer.valueOf(100);

        System.out.println(a == b);
        System.out.println(a == e);

        System.out.println(c == d);
        System.out.println(c == f);
    }
}
