package com.mbti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mbti.Repository.TravelRepository;

import com.mbti.vo.Travel;

@Service
public class TravelService {
	
	@Autowired
	private TravelRepository travelRepository;
	 
	 public List<Travel> getTravelsByMbtiName(String mbtiName) {
	        return travelRepository.findByMbtiName(mbtiName);
	    }

}
