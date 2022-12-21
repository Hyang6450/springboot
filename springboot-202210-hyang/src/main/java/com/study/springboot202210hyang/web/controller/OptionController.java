package com.study.springboot202210hyang.web.controller;

import com.study.springboot202210hyang.service.OptionService;
import com.study.springboot202210hyang.web.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/option")
public class OptionController {

    @Autowired
    private OptionService optionService;

    @PostMapping("/category")
    public ResponseEntity<?> addCategory(@RequestBody CategoryDto categoryDto) { // @RequestBody가 있는 이유는 데이터를 JSON형태로 받기 때문이다.

        return ResponseEntity
                .created(URI.create("/api/option/category/"+optionService.addCategory(categoryDto))) // created는 201번 코드이다. headers에 저장가능하게 만드는 구문이다.
                .body(categoryDto);
    }
// @RequestMapping(value = "/categories", method = RequestMethod.GET)이랑 밑에 @GetMapping과 동일하다.
    @GetMapping("/categories")
    public ResponseEntity<?> getCategory(){
        return ResponseEntity.ok(optionService.getCategories());
    }

    @PutMapping("/category/{categoryId}")
    public ResponseEntity<?> modifyCategory(@PathVariable int categoryId, @RequestBody CategoryDto categoryDto) {
        optionService.modifyCategory(categoryId, categoryDto);
        return ResponseEntity.ok(true);
    }
}
