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

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/register.html")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/register.html")
	public String registerUser(@ModelAttribute User user, Model model) {
		System.out.println(user);

		if (user.getRole() == null || user.getRole().isEmpty()) {
			user.setRole("USER");
		}

		userService.registerUser(user);
		model.addAttribute("registrationSuccess", true); // 성공 상태 전달

		return "login.html"; // 성공 후 리다이렉트
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("user", new User());
		return "login.html";
	}

	@PostMapping("/login")
	public String login(String username, String password, HttpSession session) {
		// 예시: 사용자 인증 확인 (DB에서 조회)
		User user = userService.findByUsernameAndPassword(username, password);

		if (user != null) {
			// 세션에 사용자 정보를 저장
			session.setAttribute("loggedInUser", user);
			// System.out.println("세션에 저장된 사용자: " + user.getUsername());
			return "redirect:/home.html"; // 로그인 성공 시 프로필 페이지로 리다이렉트
		} else {
			return "redirect:/login?error=true"; // 로그인 실패 시
		}
	}

}
