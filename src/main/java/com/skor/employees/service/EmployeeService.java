package com.skor.employees.service;

import com.skor.employees.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    void deleteEmployee(int id);

    Optional<Employee> showEmployeeById(int id);

}
