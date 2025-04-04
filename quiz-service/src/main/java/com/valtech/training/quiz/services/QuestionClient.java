package com.valtech.training.quiz.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.valtech.training.quiz.vos.QuestionVO;

@Component
public class QuestionClient{
	
	
	public List<QuestionVO> getAllQuestionByTopic(String topic,int number){
		RestTemplate temp=new RestTemplate();
		String urlForTopic="http://localhost:9030/api/v1/questions/random/"+topic+"/"+number;
		List<QuestionVO> questions=Arrays.asList(temp.getForObject(urlForTopic, QuestionVO[].class));
		return questions;
	}
	

	public List<QuestionVO> getQuestionsByIds(List<Integer>ids){
		RestTemplate temp=new RestTemplate();
		String urlForId= "http://localhost:9030/api/v1/question/ques/"+ids.stream().map(String::valueOf).collect(Collectors.joining(","));
		List<QuestionVO> questions=Arrays.asList(temp.getForObject(urlForId, QuestionVO[].class));
		return questions;
	}


	public List<QuestionVO> getQuestionsByTopicFromQuestions(String topic) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
}
	


