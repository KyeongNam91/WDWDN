package com.mbti.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="exercise")
public class Exercise {
	
	@Id
	@GeneratedValue
	private Long exercise_id;
	
	@Column(name = "mbti_name")
	private String mbtiName;
	
	private String exercise_name;
	private String exercise_comment;
	private String exercise_info;
    private String exercise_map;
    private String mbti_comm;
    

}
