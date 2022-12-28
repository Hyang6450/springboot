package com.study.springboot202210hyang.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 'runtime 시점에 사용을 할 거다'라는 의미
@Target({ElementType.TYPE, ElementType.METHOD}) // type -> class를 의미한다.
                                                // method -> 이 어노테이션을 어디에 사용할 건가 라는 의미를 갖고 있다.
public @interface PrintTestAspect {}
