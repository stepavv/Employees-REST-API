package com.skor.employees.controller;


import com.skor.employees.dto.EmployeeDTO;
import com.skor.employees.entity.Employee;
import com.skor.employees.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "main_methods")
@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    @Operation(
            summary = "shows information about all employees"
    )
    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @Operation(
            summary = "shows information about an employee with a specific id"
    )
    @GetMapping("/employees/{id}")
    public Optional<Employee> showEmployeeById(@PathVariable int id) {
        return employeeService.showEmployeeById(id);
    }


    @Operation(
            summary = "adds an employee"
    )
    @PostMapping("/employees")
    public String addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.saveEmployee(Employee.builder()
                .name(employeeDTO.getName())
                .surname(employeeDTO.getSurname())
                .department(employeeDTO.getDepartment())
                .salary(employeeDTO.getSalary())
                .build());
        return "A new employee has been added successfully.";
    }

    @Operation(
            summary = "alters employee's information"
    )
    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
        Optional<Employee> employee = showEmployeeById(id);
        if (employee.get().equals(updatedEmployee)) {
            return employee.get();
        }
        employee.get().setName(updatedEmployee.getName());
        employee.get().setSurname(updatedEmployee.getSurname());
        employee.get().setDepartment(updatedEmployee.getDepartment());
        employee.get().setSalary(updatedEmployee.getSalary());
        employeeService.saveEmployee(updatedEmployee);
        return employee.get();
    }

    @Operation(
            summary = "removes an employee"
    )
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return "Employee with id = " + id + " has been deleted";
    }
}
