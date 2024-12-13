package com.mbti.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@GetMapping("/home.html")
	public String homePage(Model model, Principal principal) {
	    if (principal != null) {
	        String username = principal.getName(); // 로그인된 유저 이름
	        model.addAttribute("username", username); // 모델에 추가
	    } else {
	        model.addAttribute("username", "Guest"); // 기본값 설정
	    }
	    
	    return "home.html";
	}
	    @PostMapping("/home.html")
	    public String homePagePost(@RequestParam("extraData") String extraData, 
	                               Model model, 
	                               Principal principal) {
	        String username = principal.getName(); // 로그인된 유저 이름
	        model.addAttribute("username", username); // 모델에 추가
	        model.addAttribute("extraData", extraData); // POST 요청으로 받은 데이터 추가
	       // System.out.println("Username: " + username);
	        return "home.html"; // home.html로 이동
	        
	    }
	}