package com.study.springboot202210hyang.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller1 {
 //   @RequestMapping(value = "/page1", method = RequestMethode.GET)
    @GetMapping("/page1")
    public String page1() {
        return "page1";
    }
//@ResponseBody 응답의 데이터가 된다. 그 페이지는 텍스트로 받는다. 없으면 뷰리저버로 간다.
    @GetMapping("/page2")
    public String page2() {
        return "page2";
    }

}
