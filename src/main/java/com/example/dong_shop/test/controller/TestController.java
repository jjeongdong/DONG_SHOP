package com.example.dong_shop.test.controller;

import com.example.dong_shop.test.dto.TestDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String hello() {
        return "hello World";
    }

    @GetMapping("/testDto")
    public TestDto testDto() {
        TestDto dto = new TestDto();
        dto.setName("정동훈");
        dto.setAge(10);

        return dto;
    }
}
