package com.mbti;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig  {
	 @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	 
	  @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http.csrf().disable()
	            .authorizeHttpRequests(auth -> auth
	            .requestMatchers("/css/**", "/js/**","/medias/**", "/images/**","/home.html","/login.html","/register.html","/list1.html","/list2.html","/list3.html").permitAll() // 정적 자원 허용
	            .anyRequest().authenticated()
	        )
	            .formLogin(form -> form
	                .loginPage("/login")
	                .defaultSuccessUrl("/home.html", true)
	                .failureUrl("/login?error=true")
	                .permitAll()
	            )
	            .logout(logout -> logout
	                .logoutUrl("/logout")
	                .logoutSuccessUrl("/home.html")
	                .invalidateHttpSession(true)
	                .deleteCookies("JSESSIONID")
	                .permitAll()
	            );
	        
	        return http.build();

	  }
	}