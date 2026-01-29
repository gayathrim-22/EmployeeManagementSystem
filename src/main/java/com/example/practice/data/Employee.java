package com.example.practice.data;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name="employee")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",nullable = false,length = 50)
    private String name;
    @Column(name = "job",nullable = false,length = 30)
    private String job;
    @Column(name = "sal",nullable = false)
    private Double sal;
    @Column(name = "hiredate")
    private String hireDate;
}
