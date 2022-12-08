package com.study.springboot202210hyang.IocAndDi;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component // 생성할 수 있는 객체에 달아줘야한다.
@Service
public class StudentServiceImpl implements StudentService {
    @Override
    public void printStudentInfo(Student student) {
        System.out.println("학번: " + student.getStudentId());
        System.out.println("이름: " + student.getStudentName());
    }
}
