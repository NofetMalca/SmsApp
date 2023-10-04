package com.example.springStart.BaseORM.Repositories;

import com.example.springStart.BaseORM.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    List<Employee> findByFirstNameAndLastName(String firstName, String lastName);
    List<Employee> findBySalary(int salary);
    List<Employee> findBySalaryAndFirstName(int salary, String name);
    List<Employee> findBySalaryOrFirstName(int salary, String name);
    List<Employee> findByIdNotLike(String employeeId);
}
