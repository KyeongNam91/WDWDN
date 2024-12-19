package com.mbti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbti.Repository.GameRepository;
import com.mbti.vo.Game;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	 
	 public List<Game> getGamesByMbtiName(String mbtiName) {
	        return gameRepository.findByMbtiName(mbtiName);
	    }

}
