package com.valtech.training.quiz.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.valtech.training.quiz.vos.QuestionVO;

@Component
public class QuestionClient{
	
	
	String url = "http://localhost:9030/api/v1/questions/";
	public List<QuestionVO> getQuestionsByTopicFromQuestion(String topic) {
		RestTemplate temp = new RestTemplate();
		String url1 = url+"topic/"+topic;
		List<QuestionVO> questions = Arrays.asList(temp.getForObject(url1,QuestionVO[].class));
		return questions;
	}

	public List<QuestionVO> getQuestionsByIds(List<Integer> questionsIds) {
	
		RestTemplate temp = new RestTemplate();
		String url2 = url + "questions/"+questionsIds.stream().map(String::valueOf).collect(Collectors.joining(","));
		
		List<QuestionVO> questions = Arrays.asList(temp.getForObject(url2,QuestionVO[].class));

		return questions;
	}

	
	
}
	


