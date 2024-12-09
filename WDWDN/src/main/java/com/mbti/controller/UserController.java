package com.mbti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	    @PostMapping("/register")
	    public String registerUser(@ModelAttribute User user) {
	    	//System.out.println(user);
	    	userService.registerUser(user);
	
	        return "redirect:/home.html";
	    }
}
