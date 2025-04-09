package com.valtech.training.quiz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.quiz.services.QuizService;
import com.valtech.training.quiz.vos.QuestionVO;
import com.valtech.training.quiz.vos.QuizVO;

@RestController
@RequestMapping("/api/v1/quizs")
public class QuizController {
	

	@Autowired
	private QuizService quizService;
	
	@PostMapping("/")
	public void createQuiz(@RequestBody QuizVO qivo) {
		 quizService.createQuiz(qivo);
	}
	
	@GetMapping("/{id}")
	public QuizVO getQuestion(@PathVariable("id") int id) {
		return quizService.getQuiz(id);
	}
	@GetMapping("/{topic}/{noOfQuestions}")
	public List<QuestionVO> getQuestions(@PathVariable("topic") String topic, @PathVariable("noOfQuestions") int noOfQuestions){
		return quizService.getQuesByTopicAndNoOfQue(topic, noOfQuestions);
	}
	@GetMapping("/{quizId}/questions")
	public List<QuestionVO> getQuestionsForQuiz(@PathVariable("quizId") int quizId){
		return quizService.getQuestionsByQuiz(quizId);
	}
	@GetMapping("/answers/{id}")
	public List<String> getAnswerById(@PathVariable("id") int id){
		return quizService.getAnswers(id);
	}
	@PostMapping("/takequiz/{quizId}")
	public QuizVO takeQuiz(@PathVariable("quizId") int quizId,@RequestBody List<String> answers) {
		return quizService.takeQuiz(quizId, answers);
	}
}
