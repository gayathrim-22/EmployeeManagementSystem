package com.example.practice.service;

import com.example.practice.data.emp.CreateEmpReq;
import com.example.practice.data.emp.CreateEmpRes;
import com.example.practice.data.emp.EmployeeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface EmpService {
    ResponseEntity<CreateEmpRes> createEmployee(CreateEmpReq createEmpReq);
    ResponseEntity<EmployeeDTO> getEmpById(Long id);
    ResponseEntity<String> updateEmployee();
    ResponseEntity<String> deleteEmployee();
}
