package com.training.quizapp.service;

import com.training.quizapp.entity.Question;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuestionService {

    public ResponseEntity<List<Question>> getAllQuestions();

    ResponseEntity<List<Question>> getQuestionsByCategory(String category);

    ResponseEntity<String> addQuestion(Question question);
}
