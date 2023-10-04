package com.example.springStart.BaseORM.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="employees")
public class Employee {
    @Id
    @Column(name="employee_id")
    @JsonProperty
    private String id;

    @Column(name="first_name")
    @JsonProperty
    private String firstName;

    @Column(name="last_name")
    @JsonProperty
    private String lastName;


    @JsonProperty
    @Column(name="department_id")
    private String departmentNumber;


    @Column(name="hire_date")
    @JsonProperty
    private Date hireDate;

    @Column(name="job")
    @JsonProperty
    private String job;

    @Column(name="education_level")
    @JsonProperty
    private int educationLevel;

    @Column(name="sex")
    @JsonProperty
    private char sex;

    @Column(name="birthdate")
    @JsonProperty
    private Date birthdate;

    @Column(name="salary")
    @JsonProperty
    private int salary;

    @Column(name="bonus")
    @JsonProperty
    private int bonus;

    @Column(name="commission")
    @JsonProperty
    private int commission;

    public String id() {
        return this.id;
    }

}
