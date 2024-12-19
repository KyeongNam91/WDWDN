package com.mbti.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mbti.vo.Exercise;
import com.mbti.vo.Travel;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    List<Exercise> findByMbtiName(String mbtiName); // MBTI_NAME과 일치하는 운동 목록 조회
}