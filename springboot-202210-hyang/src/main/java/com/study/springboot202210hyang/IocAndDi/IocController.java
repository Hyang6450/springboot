package com.study.springboot202210hyang.IocAndDi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IocController {

    @Qualifier("usi2")
    @Autowired // (required = false) 객체 구현이 되지 않은데 서버를 실행하고 싶을 때 사용한다.
    private UserService userService;

    // 원래는 이것을 해줘야 하는데 @Autowired를 해주면 알아서 주입을 한다.
//    public IocController(UserServiceImpl2 userService) {
//        this.userService = userService;
//    }

    @ResponseBody
    @GetMapping("/ioc")
    public String iocTest(){
        userService.createUser();
        userService.getUsers();
        userService.updateUser();
        userService.deleteUser();
        return null;
    }
}
