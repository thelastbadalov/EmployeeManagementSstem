package com.example.employee_thymleaf.service;

import com.example.employee_thymleaf.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllStudents();
    Employee saveEmployee(Employee employee);
    Employee getById(Long id);
    Employee updateEmployee(Employee employee);
void deleteEmployeeById(Long id);
}
