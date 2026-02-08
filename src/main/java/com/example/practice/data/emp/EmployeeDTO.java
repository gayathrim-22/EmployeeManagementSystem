package com.example.practice.data.emp;

import lombok.Data;

@Data
public class EmployeeDTO {
    private Long id;
    private String name;
    private String job;
    private Double sal;
    private String hireDate;
}
