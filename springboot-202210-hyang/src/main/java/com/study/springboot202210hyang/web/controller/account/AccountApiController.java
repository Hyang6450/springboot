package com.study.springboot202210hyang.web.controller.account;

import com.mysql.cj.log.Log;
import com.study.springboot202210hyang.aop.annotation.ParamsAspect;
import com.study.springboot202210hyang.aop.annotation.PrintTestAspect;
import com.study.springboot202210hyang.aop.annotation.TimerAspect;
import com.study.springboot202210hyang.aop.annotation.ValidAspect;
import com.study.springboot202210hyang.service.UserService;
import com.study.springboot202210hyang.web.dto.CMRespDto;
import com.study.springboot202210hyang.web.dto.UserDto;
import com.study.springboot202210hyang.web.dto.UsernameDto;
import com.study.springboot202210hyang.web.exception.CustomValidException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/account")
public class AccountApiController {

    // slf -> Simple Log Fasade
    //private static final Logger LOG = LoggerFactory.getLogger(AccountApiController.class); // 자기 자신의 클래스명을 입력하면 된다.

    @Autowired
    private UserService userService;


    @ParamsAspect
    @TimerAspect
    @PrintTestAspect
    @ValidAspect
    @GetMapping("/username")
    public ResponseEntity<?> duplicateUsername(@Valid UsernameDto usernameDto, BindingResult bindingResult) { // get요청은 객체를 전달하므로 json형태가 아니다.
        userService.duplicateUsername(usernameDto.getUsername());

        return ResponseEntity.ok().body(new CMRespDto<>("가입 가능한 사용자이름", true));
    }

    @ParamsAspect
    @PostMapping("/user")
    public ResponseEntity<?> register(@RequestBody @Valid UserDto userDto, BindingResult bindingResult) {
//        System.out.println(userDto);
//        System.out.println(bindingResult.getFieldErrors());
        return ResponseEntity
                .created(URI.create("/account/login"))
                .body(new CMRespDto<>("회원가입 완료", null));
    }
}
