package com.valtech.training.quiz.controllers;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.valtech.training.quiz.vos.QuizVO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class QuizControllerTests {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void addQuiz() {
		List quiz=restTemplate.getForObject("http://localhost:"+port+"/api/v1/quizes/",List.class);
		if(quiz.size()==0) {
			System.out.println("Adding Quiz");
//		QuizVO quizVo=restTemplate.postForObject(null, quiz, null)
		}
		
	}

}
