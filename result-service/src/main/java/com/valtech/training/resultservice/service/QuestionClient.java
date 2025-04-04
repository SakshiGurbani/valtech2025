package com.valtech.training.resultservice.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.client.RestTemplate;

import com.valtech.training.resultservice.vos.QuestionsVO;

public class QuestionClient {
	
	public List<String> getAnswersFromQuestionIds(List<Integer> ids){
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:9030/api/v1/questions/questions/"+ids.stream().map(String::valueOf).collect(Collectors.joining(","));
		List<QuestionsVO> questions = Arrays.asList(restTemplate.getForObject(url, QuestionsVO[].class));
		List<String> correctAnswers = questions.stream().map(q->q.ans()).collect(Collectors.toList()));
		return correctAnswers;
	}


}
