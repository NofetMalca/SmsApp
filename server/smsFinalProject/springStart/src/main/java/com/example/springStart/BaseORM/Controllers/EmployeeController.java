package com.example.springStart.BaseORM.Controllers;

import com.example.springStart.BaseORM.Models.Employee;
import com.example.springStart.BaseORM.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @CrossOrigin
    // Example: http://localhost:9000/employees
    @GetMapping("")
    public List<Employee> getAll() {
        return this.employeeService.getAll();
    }

    // Example: http://localhost:9000/employees/270
    @CrossOrigin
    @GetMapping("/{id}")
    public Optional<Employee> getById(@PathVariable String id) {
        return this.employeeService.getById(id);
    }

    // Example: http://localhost:9000/employees/contact/000270
    @CrossOrigin
    @GetMapping("/contact/{id}")
    public List<Employee> getAllEmployeesExceptId(@PathVariable String id) {
        return this.employeeService.getAllEmployeesExceptId(id);
    }

    // Example: http://localhost:9000/employees/salaryGT/50000
    @CrossOrigin
    @GetMapping("/salaryGT/{salary}")
    public List<Employee> getSalaryGT(@PathVariable int salary) {
        return this.employeeService.getSalaryGT(salary);
    }

    // Example: http://localhost:9000/employees/salaryGT/20000/andname/MARIA
    @CrossOrigin
    @GetMapping("/salaryGT/{salary}/andname/{firstname}")
    public List<Employee> getSalaryAndFirstName(@PathVariable int salary, @PathVariable String firstname) {
        return this.employeeService.getFirstNameAndSalary(salary, firstname);
    }

    // Example: http://localhost:9000/employees/salaryGT/30000/orname/MARIA
    @CrossOrigin
    @GetMapping("/salaryGT/{salary}/orname/{firstname}")
    public List<Employee> getSalaryOrFirstName(@PathVariable int salary, @PathVariable String firstname) {
        return this.employeeService.getFirstNameOrSalary(salary, firstname);
    }
}
