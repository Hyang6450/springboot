package com.study.springboot202210hyang.repository;

import com.study.springboot202210hyang.web.dto.EmpDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeRepository {
    public int saveEmployee(EmpDto empDto);
}
