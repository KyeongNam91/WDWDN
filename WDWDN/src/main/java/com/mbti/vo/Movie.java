package com.mbti.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="movie")
public class Movie {
	
	@Id
	@GeneratedValue
	private Long movie_id;
	
	@Column(name = "mbti_name")
	private String mbtiName;
	
	private String movie_name;
	private String movie_comment;
	private String movie_info;
    private String movie_view;
    private String mbti_comm;
    

}
