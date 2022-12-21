package com.study.springboot202210hyang.web.controller;

import com.study.springboot202210hyang.web.dto.CMRespDto;
import com.study.springboot202210hyang.web.dto.UserDto;
import com.study.springboot202210hyang.web.exception.CustomTestException;
import com.sun.net.httpserver.Headers;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RestController1 {

    @GetMapping("/api/test/user-dto/str") // URL에 카멜표기법은 쓰지않기로 했다..
    public String getUserDtoStr(){ // ResponseBody와 String이 만나면 응답이 텍스트이고
        UserDto userDto = UserDto.builder()
                .userId(100)
                .username("abc")
                .password("1234")
                .build();
        return userDto.toString();
    }

    @GetMapping("/api/test/user-dto/obj")
    public ResponseEntity<?> getUserDtoObj(){ //ResponseBody와 객체가 만나면 응답이 Json이다.
        UserDto userDto = UserDto.builder()
                .userId(100)
                .username("abc")
                .password("1234")
                .build();
        HttpHeaders headers = new HttpHeaders();
        headers.set("UserDto", userDto.toString());
//        return new ResponseEntity<>(headers, HttpStatus.OK);
        return ResponseEntity.ok()
                .headers(headers)
                .body(userDto);
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(userDto);
//        return ResponseEntity.ok().body(userDto);
//        return new ResponseEntity<>(userDto, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/api/test/user-dto/cm")
    public ResponseEntity<?> getUserDto() {
        UserDto userDto = UserDto.builder()
                .username("test")
                .password("1234")
                .build();
        return ResponseEntity.ok().body(new CMRespDto<>("test유저 정보 응답", userDto)); // CMRespDto(Commit Message)공통응답 객체
    }

    @PostMapping("/api/test/user")
    public ResponseEntity<?> addUser(@RequestBody UserDto userDto) {

        if(userDto.getUsername().isBlank()){
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("username", "아이디를 입력하세요.");

            throw new CustomTestException("유효성 검사 실패", errorMap);
        }

        userDto.setUserId(200);
        return ResponseEntity
                .created(null)
                .body(new CMRespDto<>(userDto.getUserId() + "사용자 추가 성공!", userDto));
    }
}
