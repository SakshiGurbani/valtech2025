package com.valtech.training.question.controllers;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.valtech.training.question.vos.QuestionsVO;

import java.util.List;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class QuestionsControllerTests {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void addQuestions() {
		List ques=restTemplate.getForObject("http://localhost:"+port+"/api/v1/questions/", List.class);
		if(ques.size()==0) {
			System.out.println("Adding Questions");
			QuestionsVO qvo=restTemplate.postForObject("http://localhost:"+port+"/api/v1/questions/",
					new QuestionsVO
					(1, "Who is the Prime Minister of India", "Shri Narendra Modi ", "Dr.rajendra Prasad",
							"Sarojini naidu", "Shri Narendra Modi", "GK"), QuestionsVO.class);
			
			QuestionsVO qvo1=restTemplate.postForObject("http://localhost:"+port+"/api/v1/questions/",
					new QuestionsVO
					(2, "Who is the President of India", "Pratibha Patil ", "Smt Draupadi Murmu",
							"Sarojini naidu", "Smt Draupadi Murmu", "GK"), QuestionsVO.class);

			QuestionsVO qvo2=restTemplate.postForObject("http://localhost:"+port+"/api/v1/questions/",
					new QuestionsVO
					(0, "Who is the President of India", "Pratibha Patil ", "Smt Draupadi Murmu",
							"Sarojini naidu", "Smt Draupadi Murmu", "GK"), QuestionsVO.class);
			
		}
	}
	
	

}
