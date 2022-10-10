package com.example.employee_thymleaf.controller;

import com.example.employee_thymleaf.entity.Employee;
import com.example.employee_thymleaf.service.EmployeeService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/employees")
    public String listStudents(Model model) {
        model.addAttribute("employees", employeeService.getAllStudents());
        return "employees";
    }

    @GetMapping("/employees/new")
    public String createEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "createEmployee";
    }

    @PostMapping("/employees")
    public String saveEmploye(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/edit/{id}")
    public String editEmployee(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.getById(id));
        return "edit_employee";
    }

    @PostMapping("/employees/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("employee") Employee employee, Model model) {
        Employee existEmployee = employeeService.getById(id);
        existEmployee.setId(id);
        existEmployee.setFirstName(employee.getFirstName());
        existEmployee.setLastName(employee.getLastName());
        existEmployee.setEmail(employee.getEmail());
        employeeService.updateEmployee(existEmployee);
        return "redirect:/employees";
    }
    @GetMapping("/employees/{id}")
public String deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);
return "redirect:/employees";
    }
}
