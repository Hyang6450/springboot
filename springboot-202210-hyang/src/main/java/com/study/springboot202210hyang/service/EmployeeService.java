package com.study.springboot202210hyang.service;

import com.study.springboot202210hyang.repository.EmployeeRepository;
import com.study.springboot202210hyang.web.dto.EmpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    public EmployeeRepository employeeRepository;

    public int addEmployee(EmpDto empDto){
        employeeRepository.saveEmployee(empDto);
        return empDto.getEmpId();
    }
}
