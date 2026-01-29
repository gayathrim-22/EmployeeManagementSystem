package com.example.practice.controller;

import com.example.practice.data.CreateEmpReq;
import com.example.practice.data.CreateEmpRes;
import com.example.practice.service.EmpService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    private final EmpService empService;

    @Autowired
    public UserController(EmpService empService) {
        this.empService = empService;
    }

    @PostMapping
    public ResponseEntity<CreateEmpRes> createEmployee(@Valid @RequestBody CreateEmpReq createEmpReq) {
        log.info("Creating employee: {}", createEmpReq);
        return empService.createEmployee(createEmpReq);
    }
}