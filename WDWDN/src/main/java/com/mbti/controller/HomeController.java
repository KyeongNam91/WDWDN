package com.mbti.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mbti.service.MovieService;
import com.mbti.service.UserService;
import com.mbti.vo.Movie;

@Controller
public class HomeController {

	@Autowired
	private UserService userService; // UserService 주입
	
	@Autowired
	private MovieService movieService;
	
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

		        if (username != null) {
		            String mbti = userService.getUserMbti(username); // MBTI 값 가져오기
		            List<Movie> movies = movieService.getMoviesByMbtiName(mbti); // MBTI와 일치하는 영화 데이터 가져오기
		            
		            model.addAttribute("username", username);
		            model.addAttribute("mbti", mbti); // 모델에 MBTI 추가
		            model.addAttribute("movies", movies); // 영화 데이터를 모델에 추가
		           
		        }
		        return "list1.html"; // home.html로 이동
		    }
		
	    
	    @PostMapping("/list1.html")
	    public String listPost(Model model, Principal principal) {
	        String username = principal.getName(); // 로그인된 유저 이름
	        String mbti = userService.getUserMbti(username); // MBTI 값 가져오기
	        
	        model.addAttribute("username", username);  
	        model.addAttribute("mbti", mbti); // 모델에 MBTI 추가

	        return "list1.html"; // home.html로 이동
	        
	    }
	    
	    
	}