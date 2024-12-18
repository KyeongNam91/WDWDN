package com.mbti.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="travel")
public class Travel {
	
	@Id
	@GeneratedValue
	private Long travel_id;
	
	@Column(name = "mbti_name")
	private String mbtiName;
	
	private String travel_name;
	private String travel_comment;
	private String travel_info;
    private String travel_map;
    private String mbti_comm;
    

}
