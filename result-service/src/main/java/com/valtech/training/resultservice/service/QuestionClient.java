package com.valtech.training.resultservice.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.client.RestTemplate;

public class QuestionClient {
	
	public List<String> getAnswersFromQuestionIds(List<Integer>ids){
		RestTemplate restTemplate=new RestTemplate();
		String url="http://localhost:9070/api/v1/question/ques/"+ids.stream().map(String:: valueOf)
				.collect(Collectors.joining(","));
		List<QuestionVO> questions=Arrays.asList(restTemplate.getForObject(url, QuestionVO[].class));
		List<String> correctAnswers=questions.stream().map(q->q.correctOption()).collect(Collectors.toList());
		return correctAnswers;
	}

}
