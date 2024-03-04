package com.empl.skyprohomeworkempl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public class DepartmentController {
    private final EmployeeService employeeService;

    public DepartmentController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/max-salary")
    public Employee getMaxSalaryEmployee(@RequestParam int departmentId) {
        return employeeService.findEmployeeWithMaxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee getMinSalaryEmployee(@RequestParam int departmentId) {
        return employeeService.findEmployeeWithMinSalary(departmentId);
    }

    @GetMapping("/all")
    public List<Employee> getEmployeesByDepartment(@RequestParam(required = false) Integer departmentId) {
        if (departmentId != null) {
            return employeeService.findAllEmployeesByDepartment(departmentId);
        } else {
            return employeeService.getAllEmployees();
        }
    }

    @GetMapping("/all-by-department")
    public Map<Integer, List<Employee>> getAllEmployeesGroupedByDepartment() {
        return employeeService.findAllEmployeesGroupedByDepartment();
    }
}
