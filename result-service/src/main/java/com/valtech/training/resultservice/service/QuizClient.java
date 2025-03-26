package com.valtech.training.resultservice.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class QuizClient {
	
	public List<String> getSubmittedAnswers(int id){
		RestTemplate restTemplate=new RestTemplate();
		String url="http://localhost:9070/api/v1/quiz/"+id;
		QuizVO qvo=restTemplate.getForObject(url, QuizVO.class);
		List<String> answers=qvo.answers();
		return answers;
		
	}
	
	public List<Integer> getQuesIdsFromQuiz(int quizId){
		RestTemplate restTemplate=new RestTemplate();
		String url="http://localhost:9070/api/v1/quiz/"+quizId;
		QuizVO questions=restTemplate.getForObject(url, QuizVO.class);
		
		List<Integer> ids=questions.quesID();
		return ids;
	}

}
