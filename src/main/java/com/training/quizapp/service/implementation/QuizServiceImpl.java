package com.training.quizapp.service.implementation;

import com.training.quizapp.dao.QuestionDao;
import com.training.quizapp.dao.QuizDAO;
import com.training.quizapp.entity.Question;
import com.training.quizapp.entity.Quiz;
import com.training.quizapp.model.Response;
import com.training.quizapp.service.QuizService;
import com.training.quizapp.wrapper.QuestionWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    QuizDAO quizDAO;

    @Autowired
    QuestionDao questionDao;

    @Override
    public ResponseEntity<String> createQuiz(String category, int numberQuestions, String title) {

        List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numberQuestions);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDAO.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {

        Optional<Quiz> quiz = quizDAO.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();

        for (Question q : questionsFromDB) {
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionsForUser.add(qw);
        }

        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizDAO.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int correctAnswers = 0;
        int i=0;
        for(Response response : responses){
            if(response.getResponse().equals(questions.get(i).getRightAnswer())){
                correctAnswers++;
            }
            i++;
        }
        return new ResponseEntity<>(correctAnswers,HttpStatus.OK);
    }


}
