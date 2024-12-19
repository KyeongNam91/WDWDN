package com.mbti.controller;

import java.security.Principal;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mbti.service.GameService;
import com.mbti.service.MovieService;
import com.mbti.service.TravelService;
import com.mbti.service.UserService;
import com.mbti.vo.Game;
import com.mbti.vo.Movie;
import com.mbti.vo.Travel;

@Controller
public class HomeController {

	@Autowired
	private UserService userService; // UserService 주입
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private TravelService travelService;
	
	@Autowired
	private GameService gameService;
	
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
	    
	    @GetMapping("/list2.html")
		public String travelpage(Model model, Principal principal) {
			 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		        String username = (authentication != null && authentication.getPrincipal() instanceof User)
		                ? ((User) authentication.getPrincipal()).getUsername()
		                : null;

		        if (username != null) {
		            String mbti = userService.getUserMbti(username); // MBTI 값 가져오기
		            List<Travel> travels = travelService.getTravelsByMbtiName(mbti); // MBTI와 일치하는 여행 데이터 가져오기
		            
		            model.addAttribute("username", username);
		            model.addAttribute("mbti", mbti); // 모델에 MBTI 추가
		            model.addAttribute("travels", travels); // 여행 데이터를 모델에 추가
		           
		        }
		        return "list2.html"; // home.html로 이동
		    }
		
	    @PostMapping("/list2.html")
	    public String travelPost(Model model, Principal principal) {
	        String username = principal.getName(); // 로그인된 유저 이름
	        String mbti = userService.getUserMbti(username); // MBTI 값 가져오기
	        
	        model.addAttribute("username", username);  
	        model.addAttribute("mbti", mbti); // 모델에 MBTI 추가

	        return "list2.html"; // home.html로 이동
	        
	    }
	    
	    @GetMapping("/list3.html")
	 		public String gamelpage(Model model, Principal principal) {
	 			 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	 		        String username = (authentication != null && authentication.getPrincipal() instanceof User)
	 		                ? ((User) authentication.getPrincipal()).getUsername()
	 		                : null;

	 		        if (username != null) {
	 		            String mbti = userService.getUserMbti(username); // MBTI 값 가져오기
	 		            List<Game> games = gameService.getGamesByMbtiName(mbti); // MBTI와 일치하는 게임 데이터 가져오기
	 		            
	 		            model.addAttribute("username", username);
	 		            model.addAttribute("mbti", mbti); // 모델에 MBTI 추가
	 		            model.addAttribute("games", games); // 여행 데이터를 모델에 추가
	 		           
	 		        }
	 		        return "list3.html"; // home.html로 이동
	 		    }
	 		
	 	    @PostMapping("/list3.html")
	 	    public String gamelPost(Model model, Principal principal) {
	 	        String username = principal.getName(); // 로그인된 유저 이름
	 	        String mbti = userService.getUserMbti(username); // MBTI 값 가져오기
	 	        
	 	        model.addAttribute("username", username);  
	 	        model.addAttribute("mbti", mbti); // 모델에 MBTI 추가

	 	        return "list3.html"; // home.html로 이동
	 	        
	 	    }
	    
	    @GetMapping("/recommendation")
	    public String getRecommendationPage(Principal principal, Model model) {
	        if (principal != null) {
	            String username = principal.getName();
	            String mbti = userService.getUserMbti(username);
	            model.addAttribute("username", username);
	            model.addAttribute("mbti", mbti);
	        }
	        return "recommendation";
	    }
	    
	    @GetMapping("/recomm")
	    public String getRecommendationPage(Principal principal) {
	        if (principal != null) {
	            String username = principal.getName();
	            String mbti = userService.getUserMbti(username); // 유저의 MBTI 정보 가져오기

	            // MBTI에 따라 다른 페이지로 리다이렉트
	            switch (mbti) {
	                case "ISFP","ISTJ":
	                	
	                	 Random random = new Random();
                    	boolean isList2 = random.nextBoolean(); // true 또는 false 반환
                    if (isList2) {
                        return "redirect:/list3.html";
                    } else {
                        return "redirect:/list1.html";
                    }
	                   
	                case "ESTP":
	                    return "redirect:/list2.html";
	                default:
	                    return "redirect:/default.html";
	            }
	        }
	        // 로그인되지 않은 경우 로그인 페이지로 이동
	        return "redirect:/login.html";
	    }
	    
	}