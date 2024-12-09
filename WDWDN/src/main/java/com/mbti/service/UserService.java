package com.mbti.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mbti.mapper.UserMapper;
import com.mbti.vo.User;

@Service
public class UserService {

	private final UserMapper userMapper;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public UserService(UserMapper userMapper, PasswordEncoder passwordEncoder) {
		this.userMapper = userMapper;
		this.passwordEncoder = passwordEncoder;
	}

	public void registerUser(User user) {
        // 비밀번호 암호화
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // 이메일 중복 확인
        if (userMapper.isEmailExists(user.getEmail())) {
            throw new IllegalArgumentException("이미 등록된 이메일입니다.");
        }
        // 사용자명 중복 확인
        if (userMapper.isUsernameExists(user.getUsername())) {
            throw new IllegalArgumentException("이미 등록된 사용자명입니다.");
        }
        // 기본 값 설정 (예: 기본 role 설정)
        if (user.getRole() == null) {
            user.setRole("ROLE_USER");  // 기본값: 일반 사용자
        }
        
        // MBTI 값 유효성 검사 (옵션)
        List<String> validMbtiTypes = Arrays.asList("INTJ", "INTP", "ENTJ", "ENTP", "INFJ", "INFP", "ENFJ", "ENFP", "ISTJ", "ISFJ", "ESTJ", "ESFJ", "ISTP", "ISFP", "ESTP", "ESFP");
        if (user.getMbti() != null && !validMbtiTypes.contains(user.getMbti())) {
            throw new IllegalArgumentException("유효하지 않은 MBTI 값입니다.");
        }
        userMapper.insertUser(user);

	}
}
