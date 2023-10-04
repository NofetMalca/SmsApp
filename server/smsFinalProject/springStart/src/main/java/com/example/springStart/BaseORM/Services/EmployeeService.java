package com.example.springStart.BaseORM.Services;

import com.example.springStart.BaseORM.Models.Employee;
import com.example.springStart.BaseORM.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAll() {
        return this.employeeRepository.findAll();
    }

    public List<Employee> getByFirstNameAndLastName(String firstName, String lastName) {
        return this.employeeRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public Optional<Employee> getById(String id) {
        return this.employeeRepository.findById(id);
    }

    public List<Employee> getSalaryGT(int salary) {
        return this.employeeRepository.findBySalary(salary);
    }

    public List<Employee> getFirstNameAndSalary(int salary, String firstname) {
        return this.employeeRepository.findBySalaryAndFirstName(salary, firstname);
    }

    public List<Employee> getFirstNameOrSalary(int salary, String firstname) {
        return this.employeeRepository.findBySalaryOrFirstName(salary, firstname);
    }

    public List<Employee> getAllEmployeesExceptId(String employeeId) {
        return this.employeeRepository.findByIdNotLike(employeeId);
    }

}
