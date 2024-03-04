package com.empl.skyprohomeworkempl;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    public Employee findEmployeeWithMaxSalary(int departmentId) {
        return employees.stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new RuntimeException("Employee not found."));
    }

    public Employee findEmployeeWithMinSalary(int departmentId) {
        return employees.stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new RuntimeException("Employee not found."));
    }

    public List<Employee> findAllEmployeesByDepartment(int departmentId) {
        return employees.stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> findAllEmployeesGroupedByDepartment() {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
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
//
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

    public static void main(String[] args) {
        Employee[] employeesArray = {
                new Employee("Иванов Иван Иванович", 43000.0, 1),
                new Employee("Иванов Иван Евгеньевич", 44000.0, 1),
                new Employee("Петров Игорь Валерьевич", 45000.0, 2),
                new Employee("Злыгостеев Александр Иванович", 46000.0, 2),
                new Employee("Кипнов Петр Александрович", 47000.0, 3),
                new Employee("Иванов Артём Артёмович", 48000.0, 3),
                new Employee("Сидоров Григорий Гоергиевич", 49000.0, 4),
                new Employee("Тарасенко Виталий Иванович", 50000.0, 4),
                new Employee("Наширин Иван Яковлевич", 51000.0, 5),
                new Employee("Залысов Михаил Николаевич", 52000.0, 5)
        };

        // Преобразование массива в список
        List<Employee> employeesList = new ArrayList<>();
        for (Employee employee : employeesArray) {
            employeesList.add(employee);

        }
    }
}


