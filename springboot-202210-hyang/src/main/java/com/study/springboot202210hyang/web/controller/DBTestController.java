package com.study.springboot202210hyang.web.controller;

import com.study.springboot202210hyang.service.UserService;
import com.study.springboot202210hyang.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/db/test")
public class DBTestController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto){
        System.out.println(userDto);
        int userId = userService.addUser(userDto);
        return ResponseEntity.created(URI.create("/api/db/test/user/"+userId)).body(userDto);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUser(@PathVariable int userId){
        UserDto userDto = userService.getUser(userId);
        return ResponseEntity.ok().body(userDto);
    }
}
