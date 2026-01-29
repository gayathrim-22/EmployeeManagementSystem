package com.example.practice.service;

import com.example.practice.data.CreateEmpReq;
import com.example.practice.data.CreateEmpRes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface EmpService {
    ResponseEntity<CreateEmpRes> createEmployee(CreateEmpReq createEmpReq);
    ResponseEntity<String> updateEmployee();
    ResponseEntity<String> deleteEmployee();
}
