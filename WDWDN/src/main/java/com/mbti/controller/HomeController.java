package com.mbti.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@GetMapping("/home.html")
	public String homePage(Model model, Principal principal) {
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        String username = (authentication != null && authentication.getPrincipal() instanceof User)
	                ? ((User) authentication.getPrincipal()).getUsername()
	                : null;
	        model.addAttribute("username", username); 
	        return "home.html"; // home.html로 이동
	        
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
	    
	    @GetMapping("/list1.html")
		public String listpage(Model model, Principal principal) {
			 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		        String username = (authentication != null && authentication.getPrincipal() instanceof User)
		                ? ((User) authentication.getPrincipal()).getUsername()
		                : null;
		        model.addAttribute("username", username); 
		        return "list1.html"; // home.html로 이동
		        
		    }
		
	    
	    @PostMapping("/list1.html")
	    public String listPost(@RequestParam("extraData") String extraData, 
	                               Model model, 
	                               Principal principal) {
	        String username = principal.getName(); // 로그인된 유저 이름
	        model.addAttribute("username", username); // 모델에 추가
	        model.addAttribute("extraData", extraData); // POST 요청으로 받은 데이터 추가
	       // System.out.println("Username: " + username);
	        return "list1.html"; // home.html로 이동
	        
	    }
	}