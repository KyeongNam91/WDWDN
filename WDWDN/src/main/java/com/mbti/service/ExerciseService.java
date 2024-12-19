package com.mbti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbti.Repository.ExerciseRepository;
import com.mbti.Repository.TravelRepository;
import com.mbti.vo.Exercise;
import com.mbti.vo.Travel;

@Service
public class ExerciseService {
	
	@Autowired
	private ExerciseRepository exerciseRepository;
	 
	 public List<Exercise> getExercisesByMbtiName(String mbtiName) {
	        return exerciseRepository.findByMbtiName(mbtiName);
	    }

}
