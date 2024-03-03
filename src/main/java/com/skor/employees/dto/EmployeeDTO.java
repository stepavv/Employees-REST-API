package com.skor.employees.dto;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeDTO {
    String name;
    String surname;
    String department;
    int salary;
}
