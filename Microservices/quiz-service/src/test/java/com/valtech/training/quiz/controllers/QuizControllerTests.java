package com.valtech.training.quiz.controllers;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.valtech.training.quiz.services.QuestionClient;
import com.valtech.training.quiz.services.QuizService;
import com.valtech.training.quiz.vos.QuizVO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class QuizControllerTests {
	

	@Autowired
	private QuizService quizService;
	
	@LocalServerPort
	private Integer port;
	
	@Autowired
	private QuestionClient questionClient;
	
	@Autowired
	private TestRestTemplate restTemplate;


	@Test
	public void testGeneratedQuiz() { 
		String url = "http://localhost:"+port+"/api/v1/quizes/";
		QuizVO quiz = restTemplate.postForObject(url, new QuizVO(0,2,"Java",null,null), QuizVO.class);
	}
	
	@Test
	public void testTakeQuiz() {
		String url = "http://localhost:"+port+"/api/v1/quizes/takequiz/28";
		QuizVO quiz = restTemplate.postForObject(url, List.of("Object","None"), QuizVO.class);
	}
	
	@Test
	public void testGetQuestionsForQuiz() {
		String url = "http://localhost:"+port+"/api/v1/quizes/28/questions";
		QuizVO qvo = quizService.getQuiz(28);
			
		
	} 
	
		@Test
		public void getQuiz() {
		String url = "http://localhost:"+port+"/api/v1/quizes/28";
		QuizVO questions = restTemplate.getForObject(url, QuizVO.class);
	
	}

}
