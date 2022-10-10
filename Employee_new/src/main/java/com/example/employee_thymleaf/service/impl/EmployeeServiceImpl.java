package com.example.employee_thymleaf.service.impl;

import com.example.employee_thymleaf.entity.Employee;
import com.example.employee_thymleaf.repository.EmployeeRepository;
import com.example.employee_thymleaf.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAllStudents() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getById(Long id) {
return  employeeRepository.findById(id).get();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }
}
