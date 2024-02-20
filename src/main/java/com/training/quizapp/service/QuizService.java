package com.training.quizapp.service;

import com.training.quizapp.model.Response;
import com.training.quizapp.wrapper.QuestionWrapper;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuizService {
    ResponseEntity<String> createQuiz(String category, int numberQuestions, String title);

    ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id);

    ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses);
}
