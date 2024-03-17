package com.empl.skyprohomeworkempl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private static final int MAX_EMPLOYEES = 10;
    private final List<Employee> employees;

    public EmployeeService() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (StringUtils.isBlank(employee.getFirstName()) || StringUtils.isBlank(employee.getLastName())) {
            throw new IllegalArgumentException("Имя или фамилия сотрудника не могут быть пустыми.");
        }
        String formattedFirstName = StringUtils.capitalize(employee.getFirstName().toLowerCase());
        String formattedLastName = StringUtils.capitalize(employee.getLastName().toLowerCase());

        employee.setFirstName(formattedFirstName);
        employee.setLastName(formattedLastName);

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


