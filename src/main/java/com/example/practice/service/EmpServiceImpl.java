package com.example.practice.service;

import com.example.practice.data.CreateEmpReq;
import com.example.practice.data.CreateEmpRes;
import com.example.practice.data.EmpRepo;
import com.example.practice.data.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;
@RequiredArgsConstructor
@Service
public class EmpServiceImpl implements EmpService{
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private EmpRepo empRepo;
    @Override
    public ResponseEntity<CreateEmpRes>createEmployee(CreateEmpReq createEmpReq) {

        boolean exists = empRepo.existsByName(createEmpReq.getName());
        if(exists == true) {
            throw new IllegalArgumentException("User with given email/mobile already exists");
        }
        Employee employee=mapper.convertValue(createEmpReq,Employee.class);
        //Set the required values depeneding on the requirement
//        employee.setActive(true);

        Employee employee1=empRepo.save(employee);

        long userId = employee1.getId();

        CreateEmpRes response=new CreateEmpRes();
        response.setId(userId);
        response.setMessage("User Created");

        //return the response object with ResponseEntity
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    public ResponseEntity<String> updateEmployee() {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteEmployee() {
        return null;
    }
}
