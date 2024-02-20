package com.training.quizapp.dao;

import com.training.quizapp.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDAO extends JpaRepository<Quiz,Integer> {
}
