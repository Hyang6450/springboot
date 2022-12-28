package com.study.springboot202210hyang.aop;

import com.study.springboot202210hyang.web.exception.CustomValidException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class ValidationAop {

    // 앞의 * => 반환 자료형을 입력하는 곳이다. 경로 안에 들어있는 클래스안에 들어있는 모든 메소드명이다.
    // 뒤의 * => 메소드명을 지정해줄 수 있다.
    // (..) => 매개변수이다. 몇개든 상관없다라는 의미
    @Pointcut("execution(* com.study.springboot202210hyang.web.controller.account.AccountApiController.*(..))")
    private void executionPointCut(){}

    @Pointcut("@annotation(com.study.springboot202210hyang.aop.annotation.ValidAspect)")
    private void annotationPointCut() {}

    @Around("annotationPointCut()") // @Around는 전과 후 둘다를 의미한다. 전과 후 둘다 @Validation을 한다.
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable { // proceedingJoinPoint -> 해당 메소드들의 정보들이 다 들어있음.
        Object[] args = proceedingJoinPoint.getArgs(); // args => 메소드 안에있는 매개변수
        for (Object arg : args) {
            System.out.println(arg);
        }


        System.out.println("AOP 작동함!!");

        BeanPropertyBindingResult bindingResult = null;

        for(Object arg : args){
            if(arg.getClass() == BeanPropertyBindingResult.class){
                bindingResult = (BeanPropertyBindingResult) arg;
                break;
            }
        }

        if(bindingResult != null){
            if(bindingResult.hasErrors()){
                Map<String, String> errorMap = new HashMap<>();
                bindingResult.getFieldErrors().forEach(error -> {
                    errorMap.put(error.getField(), error.getDefaultMessage());
                });

                throw new CustomValidException(errorMap);
            }
        }

        // proceed() => 실행된 메소드(위에서 메소드 지정한 것)
        // 메소드 호출 전 처리
        Object returnValue = proceedingJoinPoint.proceed();
        // 메소드 호출 후 처리

        return returnValue;
    }
}
