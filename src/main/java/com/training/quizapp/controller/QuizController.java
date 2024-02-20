package com.training.quizapp.controller;

import com.training.quizapp.entity.Question;
import com.training.quizapp.model.Response;
import com.training.quizapp.service.QuizService;
import com.training.quizapp.wrapper.QuestionWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;


    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam("numQ") int numberQuestions, @RequestParam String title) {
        return quizService.createQuiz(category,numberQuestions,title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable("id") Integer id){
       return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Response> responses){
    return quizService.calculateResult(id,responses);
    }
}
