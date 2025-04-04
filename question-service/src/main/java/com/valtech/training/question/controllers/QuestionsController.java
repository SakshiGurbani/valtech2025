package com.valtech.training.question.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.valtech.training.question.services.QuestionsService;
import com.valtech.training.question.vos.QuestionsVO;

@RestController
@RequestMapping("/api/v1/questions")
public class QuestionsController {
	
	@Autowired
	private QuestionsService questionsService;
	
	@GetMapping("/{id}")
	public QuestionsVO getQuestions(@PathVariable("id") long id) {
		return questionsService.getQuestionsById(id);
	}
	
	@GetMapping("/")
	public List<QuestionsVO> getAllQuestions() {
		return questionsService.getAllQuestions();
	}
	
	
	@GetMapping("/topic/{topic}")
	public List<QuestionsVO> getQuestionByTopic(@PathVariable("topic") String topic){
		return questionsService.getQuestionByTopic(topic);
	}
	
	@GetMapping("/random/{topic}/{number}")
	public List<QuestionsVO> getRandomQuestionByTopic(@PathVariable("topic") String topic, @PathVariable("number")int number){
		return questionsService.getRandomQuestionByTopic(topic,number);
	}
	
//	@GetMapping("/ques/{ids}")
//	public List<QuestionsVO> getQuestionsByIds(@PathVariable("ids") String ids){
//		List<Integer>id=Arrays.stream(ids.split(",")).map(Integer::parseInt).collect(Collectors.toList());
//		return questionsService.getQuestionsByListOfIds(id);
//	}
	
	
	@PostMapping("/")
	public QuestionsVO createQuestions(@RequestBody QuestionsVO questionsVO) {
		return  questionsService.saveOrUpdateQuestions(questionsVO);
	}

}
