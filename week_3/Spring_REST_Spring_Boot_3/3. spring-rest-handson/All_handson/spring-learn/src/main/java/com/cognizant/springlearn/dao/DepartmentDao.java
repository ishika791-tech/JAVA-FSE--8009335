package com.cognizant.springlearn.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.model.Department;

@Repository
public class DepartmentDao {

    private static List<Department> DEPARTMENT_LIST = new ArrayList<>();

    public DepartmentDao() {

        if (!DEPARTMENT_LIST.isEmpty()) {
            return;
        }

        DEPARTMENT_LIST.add(new Department(1, "Human Resources"));
        DEPARTMENT_LIST.add(new Department(2, "Finance"));
        DEPARTMENT_LIST.add(new Department(3, "IT"));
    }

    public List<Department> getAllDepartments() {
        return DEPARTMENT_LIST;
    }
}