package com.mbti.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="game")
public class Game {
	
	@Id
	@GeneratedValue
	private Long game_id;
	
	@Column(name = "mbti_name")
	private String mbtiName;
	
	private String game_genre;
	private String game_name;
	private String game_platform;
	private String game_comment;
	private String game_info;
    private String game_view;
    private String mbti_comm;
    

}
