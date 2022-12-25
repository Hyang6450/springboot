package com.study.springboot202210hyang.web.controller;

import com.study.springboot202210hyang.service.EmployeeService;
import com.study.springboot202210hyang.web.dto.CMRespDto;
import com.study.springboot202210hyang.web.dto.EmpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/api/emp")
    public ResponseEntity<?> addEmployee(@RequestBody EmpDto empDto) {
        return ResponseEntity
                .created(URI.create("/api/emp/"+employeeService.addEmployee(empDto)))
                .body(new CMRespDto<>("직원 등록 완료", empDto));
    }
}
