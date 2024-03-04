package com.empl.skyprohomeworkempl;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee getMaxSalary(@RequestParam int departmentId) {
        return departmentService.findEmployeeWithMaxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee getMinSalary(@RequestParam int departmentId) {
        return departmentService.findEmployeeWithMinSalary(departmentId);
    }

    @GetMapping("/all")
    public List<Employee> getEmployeesByDepartment(@RequestParam(required = false) Integer departmentId) {
        if (departmentId != null) {
            return departmentService.findEmployeesByDepartment(departmentId);
        } else {
            return departmentService.groupEmployeesByDepartment().values().stream()
                    .flatMap(List::stream)
                    .collect(Collectors.toList());
        }
    }
}
