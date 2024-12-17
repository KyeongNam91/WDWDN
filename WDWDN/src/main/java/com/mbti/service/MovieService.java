package com.mbti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbti.Repository.MovieRepository;
import com.mbti.vo.Movie;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	 
	 public List<Movie> getMoviesByMbtiName(String mbtiName) {
	        return movieRepository.findByMbtiName(mbtiName);
	    }

}
