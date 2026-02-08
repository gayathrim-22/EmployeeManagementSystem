package com.example.practice.controller;

import com.example.practice.data.emp.CreateEmpReq;
import com.example.practice.data.emp.CreateEmpRes;
import com.example.practice.data.emp.EmployeeDTO;
import com.example.practice.service.EmpServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor
public class EmployeeController {
    private final EmpServiceImpl empService;

    @PostMapping
    public ResponseEntity<CreateEmpRes> createEmployee(@Valid @RequestBody CreateEmpReq createEmpReq) {
        log.info("Creating employee: {}", createEmpReq);
        return empService.createEmployee(createEmpReq);
    }

    @GetMapping("/{id}")
    ResponseEntity<EmployeeDTO> getEmpById(@PathVariable Long id){
        log.info("getUserById()");
        ResponseEntity<EmployeeDTO> response = empService.getEmpById(id);
        return response;
    }
}