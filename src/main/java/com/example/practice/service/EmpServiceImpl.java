package com.example.practice.service;

import com.example.practice.data.emp.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class EmpServiceImpl implements EmpService{

    private final ObjectMapper mapper;
    private final EmpRepo empRepo;

    @Override
    public ResponseEntity<CreateEmpRes>createEmployee(CreateEmpReq createEmpReq) {

        boolean exists = empRepo.existsByName(createEmpReq.getName());
        if(exists == true) {
            throw new IllegalArgumentException("User with given name already exists");
        }
        Employee employee=mapper.convertValue(createEmpReq,Employee.class);

        Employee employee1=empRepo.save(employee);

        long userId = employee1.getId();

        CreateEmpRes response=new CreateEmpRes();
        response.setId(userId);
        response.setMessage("User Created");

        //return the response object with ResponseEntity
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    public ResponseEntity<EmployeeDTO> getEmpById(Long id) {
        Optional<Employee> optional = empRepo.findById(id);
        Employee employee=optional.get();
        EmployeeDTO employeeDTO=mapper.convertValue(employee,EmployeeDTO.class);
        log.info("employeeDTO {}",employeeDTO);
        return ResponseEntity.ok().body(employeeDTO);
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
