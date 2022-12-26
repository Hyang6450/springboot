package com.study.springboot202210hyang.web.controller.account;

import com.study.springboot202210hyang.web.dto.CMRespDto;
import com.study.springboot202210hyang.web.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("/api/account")
public class AccountApiController {

    @GetMapping("/username")
    public ResponseEntity<?> duplicateUsername(String username) {
        System.out.println(username);
        return ResponseEntity.ok().body(new CMRespDto<>("가입가능한 사용자이름", true));
    }

    @PostMapping("/user")
    public ResponseEntity<?> register(@RequestBody UserDto userDto) {
        System.out.println(userDto);
        return ResponseEntity
                .created(URI.create("/account/login"))
                .body(new CMRespDto<>("회원가입 완료", null));
    }
}
