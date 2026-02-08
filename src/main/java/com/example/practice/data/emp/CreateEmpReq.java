package com.example.practice.data.emp;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class CreateEmpReq {
    @Length(min = 3, max = 45, message = "Name should be min-3 char and max-45 char only")
    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "Salary cannot be empty")
    @DecimalMin(value = "1000.0", message = "Salary must be at least 1000")
    @DecimalMax(value = "9999999.0", message = "Salary must be less than 9999999")
    private Double sal;

    @Length(min = 3, max = 15, message = "Job should be min-3 char and max-15 char only")
    @NotBlank(message = "Job cannot be empty")
    private String job;

    @NotBlank(message = "Hire date is required")
    private String hireDate;
}