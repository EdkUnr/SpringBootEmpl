package com.empl.skyprohomeworkempl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        Employee employee = new Employee(firstName, lastName);
        employeeService.addEmployee(employee);
        return employee;
    }

    @PostMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        Employee employee = employeeService.findEmployee(firstName, lastName);
        employeeService.removeEmployee(employee);
        return employee;
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping("/list")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<String> handleInvalidArgument(IllegalArgumentException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST) // Устанавливаем статус 400
                .body("Ошибка: " + exception.getMessage()); // Добавляем сообщение об ошибке в тело ответа
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