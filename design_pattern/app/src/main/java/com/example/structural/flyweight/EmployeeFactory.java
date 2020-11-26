package com.example.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class EmployeeFactory {
    private static final Map<String, Employee> EMPLOYEE_MAP = new HashMap<String, Employee>();

    public static Employee getManager(String department) {
        Manager manager = (Manager)EMPLOYEE_MAP.get(department);
        if (manager == null) {
            manager = new Manager(department);
            EMPLOYEE_MAP.put(department, manager);
            manager.setReportContent(" content: " + department + "的报告");
            System.out.println("创建部门经理:" + department);
        }
        return manager;
    }
}
