package com.mbti.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mbti.vo.Travel;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Long> {
    List<Travel> findByMbtiName(String mbtiName); // MBTI_NAME과 일치하는 여행 목록 조회
}