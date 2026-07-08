package com.cognizant.springlearn.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.model.Department;
import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.model.Skill;

@Repository
public class EmployeeDao {

    private static List<Employee> EMPLOYEE_LIST = new ArrayList<>();

    public EmployeeDao() {

        if (!EMPLOYEE_LIST.isEmpty()) {
            return;
        }

        Department hr = new Department(1, "Human Resources");
        Department finance = new Department(2, "Finance");
        Department it = new Department(3, "IT");

        Skill java = new Skill(1, "Java");
        Skill spring = new Skill(2, "Spring Boot");
        Skill angular = new Skill(3, "Angular");

        EMPLOYEE_LIST.add(new Employee(
                1,
                "John",
                50000,
                true,
                new Date(),
                hr,
                Arrays.asList(java, spring)));

        EMPLOYEE_LIST.add(new Employee(
                2,
                "David",
                65000,
                true,
                new Date(),
                finance,
                Arrays.asList(java)));

        EMPLOYEE_LIST.add(new Employee(
                3,
                "Mary",
                45000,
                false,
                new Date(),
                hr,
                Arrays.asList(angular)));

        EMPLOYEE_LIST.add(new Employee(
                4,
                "Smith",
                70000,
                true,
                new Date(),
                it,
                Arrays.asList(java, spring, angular)));
    }

    public List<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }
}