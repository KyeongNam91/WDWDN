package com.mbti.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.mbti.vo.User;

@Mapper
public interface UserMapper {
	// 이메일 중복 확인
    boolean isEmailExists(String email);
    
    // 사용자명 중복 확인
    boolean isUsernameExists(String username);
    void insertUser(User user);
    User findByUsername(String username);
}