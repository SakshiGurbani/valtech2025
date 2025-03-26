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
@RequestMapping("/api/v1/quiz")
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	
	@GetMapping("/{id}")
	public QuizVO getQuiz( @PathVariable("id")long id) {
		return quizService.getQuiz(id);
		
	}
	
	@GetMapping("/")
	public List<QuizVO> getAllQuizes(){
		return quizService.getAllQuizes();
	}
	
    @GetMapping("/quizId/{quizId}")
	public List<QuestionVO> getQuestionsByQuiz(@PathVariable("quizId") int quizId){
		return quizService.getQuestionsForQuiz(quizId);
	}
	
	@PostMapping("/")
	public QuizVO createQuiz(@RequestBody QuizVO qvo) {
		return quizService.saveOrUpdateQuiz(qvo);
		
	}
	
	
	
	
	@PostMapping("/takequiz/{quizId}")
	public QuizVO takeQuiz(@PathVariable ("quizId")int quizId,@RequestBody List<String> answers) {
		return quizService.takeQuiz(quizId,answers);
	}
	
	

}
