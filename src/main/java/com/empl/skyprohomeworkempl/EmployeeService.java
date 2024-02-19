package com.empl.skyprohomeworkempl;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private static final int MAX_EMPLOYEES = 10;
    private List<Employee> employees;

    public EmployeeService() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (employees.size() >= MAX_EMPLOYEES || employees.contains(employee)) {
            throw new RuntimeException("Employee cannot be added.");
        }
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            throw new RuntimeException("Employee not found.");
        }
        employees.remove(employee);
    }

    public Employee findEmployee(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                return employee;
            }
        }
        throw new RuntimeException("Employee not found.");
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }
}


