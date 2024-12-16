package com.mbti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mbti.service.UserService;
import com.mbti.vo.User;


@Controller
public class UserController {

	 private final UserService userService;
	 	
	 @Autowired
	    public UserController(UserService userService) {
	        this.userService = userService;
	    }

	 @GetMapping("/register.html")
	    public String showRegistrationForm(Model model) {
	        model.addAttribute("user", new User());
	        return "register";
	    }

	    @PostMapping("/register.html")
	    public String registerUser(@ModelAttribute User user,Model model) {
	    	System.out.println(user);
	    	
	    	  if (user.getRole() == null || user.getRole().isEmpty()) {
	    	        user.setRole("USER");
	    	    }

	    	userService.registerUser(user);
	        model.addAttribute("registrationSuccess", true);  // 성공 상태 전달
	
	        return "login.html";  // 성공 후 리다이렉트
	    }
	    
	    

	    @GetMapping("/login")
	    public String login(Model model) {
	    	  model.addAttribute("user", new User());  
	          return "login.html";  
	    }
	    
	    @PostMapping("/login")
	    public String processLogin(@ModelAttribute("user") User user, BindingResult result) {
	        // 로그인 처리 로직
	        if (result.hasErrors()) {
	            return "login.html";  // 오류가 있으면 로그인 페이지로 돌아감
	        }
	        // 로그인 성공 후 처리
	        return "redirect:/home.html";  // 로그인 후 홈 페이지로 리다이렉트
	    }
}
