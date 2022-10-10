package com.example.employee_thymleaf.repository;

import com.example.employee_thymleaf.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository  extends JpaRepository<Employee,Long> {

}
