package com.study.springboot202210hyang.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpDto {
    private int empId;
    private String empName;
    private int empAge;
    private String empPhone;
}
