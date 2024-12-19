package com.mbti.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mbti.vo.Game;
import com.mbti.vo.Movie;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findByMbtiName(String mbtiName); // MBTI_NAME과 일치하는 게임 목록 조회
}