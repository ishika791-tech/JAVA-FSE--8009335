package com.cognizant.springlearn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.springlearn.dao.EmployeeDao;
import com.cognizant.springlearn.model.Employee;

@Service
public class EmployeeService {

    private EmployeeDao employeeDao = new EmployeeDao();

    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }
}