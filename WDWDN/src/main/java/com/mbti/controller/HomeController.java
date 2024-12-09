package com.mbti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        // "index"는 src/main/resources/templates/index.html 파일을 가리킴
        return "home.html";
    }
}