package com.mbti.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String password;
	private String name;
	private String mbti;
    private String email;
    
    @Column(nullable = false)
    private String role;

}
